package service;

import model.table.Table;
import model.table.TableColumn;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by vlad on 03.01.16.
 */

@org.springframework.stereotype.Service
public class Service {

    public Table toTable(String name, ArrayList objects) {
        if (objects == null || objects.size() == 0) return null;

        TableColumn[] columns = getColumns(objects.get(0));

        List<String[]> records = new ArrayList<>();
        ListIterator iter = objects.listIterator();
        while (iter.hasNext()) {
            records.add(toColumn(iter.next()));
        }
        return new Table(name, columns, getIds(objects), records);
    }

    public Table toTable(String name, List objects) {
        if (objects == null || objects.size() == 0) return null;

        TableColumn[] columns = getColumns(objects.get(0));

        List<String[]> records = new ArrayList<>();
        ListIterator iter = objects.listIterator();
        while (iter.hasNext()) {
            records.add(toColumn(iter.next()));
        }
        return new Table(name, columns, getIds(objects), records);
    }

    private Long[] getIds(List list) {
        ArrayList<Long> id = new ArrayList<>();
        for (Object obj : list) {
            try {
                Class c = obj.getClass();
                Field f = c.getDeclaredField("id");
                f.setAccessible(true);
                Object value = f.get(obj);
                id.add(Long.parseLong(value + ""));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return id.stream().toArray(Long[]::new);
    }

    private TableColumn[] getColumns(Object obj) {
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        ArrayList<TableColumn> columns = new ArrayList<>();
        for (Field f : fields) {
            try {
                f.setAccessible(true);
                columns.add(new TableColumn(f.getName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return columns.stream().toArray(TableColumn[]::new);
    }

    private String[] toColumn(Object obj) {
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        ArrayList<String> row = new ArrayList<>();
        for (Field f : fields) {
            try {
                f.setAccessible(true);
                Object value = f.get(obj);
                row.add(value + "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return row.stream().toArray(String[]::new);
    }

}
