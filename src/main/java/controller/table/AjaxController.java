package controller.table;

import model.table.Table;
import model.table.ajax.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import repository.CarRepo;
import repository.ColorRepo;
import repository.CustomQueryRepo;
import service.Service;
import test.table.TableGen;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by vlad on 19.11.15.
 */
@Controller
@RequestMapping(value = "/data")
public class AjaxController {

    @Autowired
    CarRepo carRepo;

    @Autowired
    ColorRepo colorRepo;

    @Autowired
    Service service;

    @PersistenceContext
    EntityManager entityManager;

    CustomQueryRepo cqRepo = new CustomQueryRepo();

    private JpaRepository getRepo(String tableName) {
        switch (tableName) {
            case "cars":
                return carRepo;
            case "color":
                return colorRepo;
            default:
                return null;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/get/{tn}")
    public Object getRecords(@PathVariable("tn") String tableName) {
        System.out.println(tableName);
//        javax.persistence.Query q = entityManager.createNativeQuery("SELECT * FROM " + tableName);
//        List l = q.getResultList();
//        Table table = service.toTable(tableName, getRepo(tableName).findAll());
        Table table = null;
        try {
            table = cqRepo.execute("SELECT * FROM " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
            return new JsonMessage("BAD");
        }
        table.setTableName(tableName);
        return table;
    }

    @ResponseBody
    @RequestMapping(value = "/update", method = RequestMethod.POST, headers = "Accept=application/json")
    public UpdateResponse update(@RequestBody Update update) {
//        System.out.println(update.getTableName());
//        System.out.println(update.getId());
//        for (String s : update.getFields()) {
//            System.out.println(s);
//        }

        String SQL = "UPDATE " + update.getTableName() + " SET ";
        for (int i = 0; i < update.getColumns().length - 1; i++) {
            if (!update.getColumns()[i].equals("id"))
                SQL += update.getColumns()[i] + "='" + update.getFields()[i] + "', ";
        }
        SQL += update.getColumns()[update.getColumns().length - 1] + "='"
                + update.getFields()[update.getColumns().length - 1]
                + "' WHERE id=" + update.getId();

        System.out.println(SQL);

        try {
            cqRepo.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
            return new UpdateResponse("BAD");
        }

        return new UpdateResponse("OK");
    }

    @ResponseBody
    @RequestMapping(value = "/add", method = RequestMethod.POST, headers = "Accept=application/json")
    public AddResponse add(@RequestBody Add add) {
//        System.out.println(add.getTableName());
//        for (String s : add.getFields()) {
//            System.out.println(s);
//        }

        boolean haveId = false;

        String SQL = "INSERT INTO " + add.getTableName() + " (";
        for (int i = 0; i < add.getColumns().length - 1; i++) {
            if (!add.getColumns()[i].equals("id"))
                SQL += add.getColumns()[i] + ", ";
        }
        SQL += add.getColumns()[add.getColumns().length - 1] + ") VALUES (";

        for (int i = 0; i < add.getFields().length - 1; i++) {
            if (add.getColumns()[i].equals("id")) {
//                SQL += "nextval('hibernate_sequence'), ";
                haveId = true;
            } else {
                SQL += "'" + add.getFields()[i] + "', ";
            }
        }
        SQL += "'" + add.getFields()[add.getFields().length - 1] + "')";

//        if (haveId) SQL += " RETURNING id";
//        if (haveId) SQL += "; SELECT SCOPE_IDENTITY()";

        System.out.println(SQL);

        Table table;
        try {
            cqRepo.execute(SQL);
            table = cqRepo.execute("SELECT SCOPE_IDENTITY() as id");
        } catch (SQLException e) {
            e.printStackTrace();
            return new AddResponse("BAD", null);
        }

        return new AddResponse("OK", table.getId()[0]);
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST, headers = "Accept=application/json")
    public DeleteResponse delete(@RequestBody Delete delete) {
//        System.out.println(delete.getTableName());
//        System.out.println(delete.getId());

        String SQL = "DELETE FROM " + delete.getTableName() + " WHERE id=" + delete.getId();

        System.out.println(SQL);

        try {
            cqRepo.execute(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
            return new DeleteResponse("BAD");
        }

        return new DeleteResponse("OK");
    }

    @ResponseBody
    @RequestMapping(value = "/test/{n}")
    public Table test(@PathVariable("n") int n) {
        return TableGen.getTable(3, n);
    }

}
