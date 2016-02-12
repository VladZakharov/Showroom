package repository;

import model.table.Table;
import model.table.TableColumn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 06.01.16.
 */
public class CustomQueryRepo {

    //    private String connectionUrl = "jdbc:postgresql://localhost:5432/itis-test";
    private String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
            "databaseName=itis-test;";
    private Connection con = null;
    private Statement stmt = null;
    private ResultSet rs = null;

    {
        connect();
    }

    public static void main(String[] args) {

        CustomQueryRepo cqRepo = new CustomQueryRepo();
        cqRepo.getTablesList();
//        Table t = null;
//        try {
//            t = cqRepo.execute("SELECT * FROM Color");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(t);
        cqRepo.close();
    }

    private void connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
//            con = DriverManager.getConnection(connectionUrl, "postgres", "postgres");
            con = DriverManager.getConnection(connectionUrl, "vlad", "123456");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<String> getTablesList() {
        List<String> tables = new ArrayList<>();
        try {
            ResultSet rs = con.getMetaData().getTables(null, null, "%", new String[]{"TABLE"});
            while (rs.next()) {
                tables.add(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return tables;
    }

    public ResultSet query(String query) throws SQLException {
        stmt = con.createStatement();
        try {
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
//            e.printStackTrace();
            if (e.getMessage().equals("Инструкция не вернула результирующий набор.")) return null;
            else {
                throw new SQLException(e);
            }
        }
        return rs;
    }

    public Table execute(String query) throws SQLException {

        ResultSet rs = query(query);
        if (rs == null) return null;
         TableColumn[] columns = getColumns(rs);
        List<String[]> records = new ArrayList<>();
        List<Long> id = new ArrayList<>();

        while (rs.next()) {
            id.add(rs.getLong("id"));
            String[] row = new String[columns.length];
            for (int i = 0; i < columns.length; i++) {
                row[i] = rs.getString(columns[i].getSystemName());
            }
            records.add(row);
        }

        return new Table(getTableName(rs), columns, id.stream().toArray(Long[]::new), records);
    }

    private String getTableName(ResultSet rs) {
        try {
            String tn = rs.getMetaData().getTableName(1);
            return tn;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private TableColumn[] getColumns(ResultSet rs) {
        TableColumn[] columns = null;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            columns = new TableColumn[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columns[i - 1] = new TableColumn(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columns;
    }

    private void close() {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (Exception e) {
        }
    }

}
