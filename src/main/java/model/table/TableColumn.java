package model.table;

/**
 * Created by vlad on 02.01.16.
 */
public class TableColumn {

    private String systemName;

    private String viewName;

    public TableColumn(String systemName, String viewName) {
        this.systemName = systemName;
        this.viewName = viewName;
    }

    public TableColumn(String systemName) {
        this.systemName = systemName;
        this.viewName = systemName;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getViewName() {
        return viewName;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }
}
