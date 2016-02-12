package model.table.ajax;

/**
 * Created by vlad on 03.01.16.
 */
public class Response {

    protected String type;

    protected String status;

    public Response(String type, String status) {
        this.type = type;
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
