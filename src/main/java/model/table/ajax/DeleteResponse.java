package model.table.ajax;

/**
 * Created by vlad on 03.01.16.
 */
public class DeleteResponse extends Response {

    public DeleteResponse(String status) {
        super("delete", status);
    }

}
