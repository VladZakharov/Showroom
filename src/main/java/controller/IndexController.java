package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import service.GeneratorService;

/**
 * Created by vlad on 19.11.15.
 */
@Controller
@EnableWebMvc
public class IndexController {

    @Autowired
    GeneratorService generatorService;

    @RequestMapping(value = "/")
    public String getIndexPage() {
        return "index";
//        return "redirect:/query/create";
    }

    @RequestMapping(value = "/groups")
    public String uname() {
        return "index";
//        return "redirect:/query/create";
    }

    @RequestMapping(value = "/404")
    public String get404Page() {
        return "404";
    }

    @RequestMapping(value = "/gen/cars/{n}")
    public String generateCars(@PathVariable("n") int n) {
        generatorService.cars(n);
        return "redirect:/table/cars";
    }

    @RequestMapping(value = "/gen/cust/{n}")
    public String generateCustomers(@PathVariable("n") int n) {
        generatorService.customers(n);
        return "redirect:/table/customers";
    }

}
