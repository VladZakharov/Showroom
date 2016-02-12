package model.table.ajax;

/**
 * Created by vlad on 03.01.16.
 */
public class AddResponse extends Response {

    private Long id;

    public AddResponse(String status, Long id) {
        super("add", status);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
