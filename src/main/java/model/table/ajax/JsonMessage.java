package model.table.ajax;

/**
 * Created by vlad on 07.01.16.
 */
public class JsonMessage {

    private String message;

    public JsonMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
