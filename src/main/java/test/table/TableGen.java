package test.table;

import model.table.Table;
import model.table.TableColumn;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 02.01.16.
 */
public class TableGen {

    public static Table getTable(int c, int n) {
        TableColumn[] columns = getColumns("Field", 1, c);

        Long[] id = getId(n);

        List<String[]> records = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            records.add(getRecord("Record", i * c, c));
        }
        return new Table("test", columns, id, records);
    }

    private static TableColumn[] getColumns(String name, int i, int n) {
        TableColumn[] records = new TableColumn[n];
        for (int j = 0; j < n; j++) {
            records[j] = new TableColumn(name + (i + j));
        }
        return records;
    }

    private static String[] getRecord(String name, int i, int n) {
        String[] records = new String[n];
        for (int j = 0; j < n; j++) {
            records[j] = name + (i + j);
        }
        return records;
    }

    private static Long[] getId(int n) {
        Long[] id = new Long[n];
        for (int j = 0; j < n; j++) {
            id[j] = (long) (Math.random() * 1000);
        }
        return id;
    }

}
