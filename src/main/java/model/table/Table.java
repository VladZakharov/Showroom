package model.table;

import java.util.List;

/**
 * Created by vlad on 01.01.16.
 */
public class Table {

    private String tableName;

    private TableColumn[] columns;

    private Long[] id;

    private List<String[]> records;

    public Table() {
    }

    public Table(String tableName, TableColumn[] columns, Long[] id, List<String[]> records) {
        this.tableName = tableName;
        this.columns = columns;
        this.id = id;
        this.records = records;
    }

    public Long[] getId() {
        return id;
    }

    public void setId(Long[] id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public TableColumn[] getColumns() {
        return columns;
    }

    public void setColumns(TableColumn[] columns) {
        this.columns = columns;
    }

    public List<String[]> getRecords() {
        return records;
    }

    public void setRecords(List<String[]> records) {
        this.records = records;
    }
}
