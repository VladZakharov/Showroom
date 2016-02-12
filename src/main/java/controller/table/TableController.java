package controller.table;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by vlad on 19.11.15.
 */
@Controller
public class TableController {

    @RequestMapping(value = "/table/{name}")
    public String getTablePage(Model model, @PathVariable("name") String tableName) {
        model.addAttribute("table", tableName);
        return "table";
    }

}
