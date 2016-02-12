package model.table.ajax;

/**
 * Created by vlad on 03.01.16.
 */
public class UpdateResponse extends Response {

    public UpdateResponse(String status) {
        super("update", status);
    }
}
