package controller;

import model.table.Table;
import model.table.ajax.JsonMessage;
import model.table.ajax.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.CustomQueryRepo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by vlad on 19.11.15.
 */
@Controller
public class CustomQueryController {

    CustomQueryRepo cqRepo = new CustomQueryRepo();

    @RequestMapping(value = "/custom")
    public String createQuery(Model model) {
        model.addAttribute("table", "test");
        return "query";
    }

    @ResponseBody
    @RequestMapping(value = "/query/execute", method = RequestMethod.POST)
    public Object getRecords(@RequestBody Query query) {

        System.out.println(query.getQuery());
        Table table = null;
        try {
            table = cqRepo.execute(query.getQuery());
        } catch (SQLException e) {
            e.printStackTrace();
            return new JsonMessage("BAD");
        }

        if (table == null) {
            return new JsonMessage("OK");
        }

        return table;
    }

    @ResponseBody
    @RequestMapping(value = "/tables", method = RequestMethod.POST)
    public Object getTableNames() {

        List tables = cqRepo.getTablesList();

        if (tables == null) {
            return new JsonMessage("BAD");
        }

        return tables;
    }

}
