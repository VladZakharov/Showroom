package controller;

/**
 * Created by vlad on 19.11.15.
 */

import model.car.CarBrand;
import model.car.CarCondition;
import model.car.Color;
import model.customer.CustomerDemands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value = "/demands")
public class DemandsController {

//    @Autowired
//    CustomerRepo customerRepo;
//
//    @Autowired
//    CustInfoRepo custInfoRepo;

    @Autowired
    DemandsRepo demandsRepo;

    @Autowired
    ConditionRepo conditionRepo;

    @Autowired
    ColorRepo colorRepo;

    @Autowired
    CarBrandRepo carBrandRepo;

    @PersistenceContext
    EntityManager entityManager;

    CustomQueryRepo customQueryRepo = new CustomQueryRepo();

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editCust(@PathVariable("id") long id, Model model) {
        CustomerDemands demands = demandsRepo.findOne(id);
        model.addAttribute("demands", demands);

        model.addAttribute("brands", carBrandRepo.findAll());
        model.addAttribute("colors", colorRepo.findAll());
        model.addAttribute("conditions", conditionRepo.findAll());

        return "edit-demands";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String updateDemands(@PathVariable("id") long id,
                                @RequestParam("brands") String[] brands,
                                @RequestParam("colors") String[] colors,
                                @RequestParam("conditions") String[] conditions,
                                @RequestParam("minEV") int minEV,
                                @RequestParam("maxEV") int maxEV,
                                @RequestParam("minHP") int minHP,
                                @RequestParam("maxHP") int maxHP,
                                @RequestParam("minTS") int minTS,
                                @RequestParam("maxTS") int maxTS,
                                @RequestParam("minP") int minP,
                                @RequestParam("maxP") int maxP) {
        CustomerDemands demands = demandsRepo.findOne(id);

        if (demands == null) return "404";

        String SQL = "SELECT * FROM CarBrand b WHERE b.name IN (";
        for (String b : brands) {
            SQL += "'" + b + "',";
        }
        SQL = SQL.substring(0,SQL.length()-1) + ")";
        System.out.println(SQL);
        List<CarBrand> brandList = entityManager.createNativeQuery(SQL, CarBrand.class).getResultList();
        demands.setBrands(brandList);

        SQL = "SELECT * FROM Color c WHERE c.name IN (";
        for (String c : colors) {
            SQL += "'" + c + "',";
        }
        SQL = SQL.substring(0,SQL.length()-1) + ")";
        System.out.println(SQL);
        List<Color> colorList = entityManager.createNativeQuery(SQL, Color.class).getResultList();
        demands.setColors(colorList);

        SQL = "SELECT * FROM CarCondition c WHERE c.name IN (";
        for (String c : conditions) {
            SQL += "'" + c + "',";
        }
        SQL = SQL.substring(0,SQL.length()-1) + ")";
        System.out.println(SQL);
        List<CarCondition> conditionList = entityManager.createNativeQuery(SQL, CarCondition.class).getResultList();
        demands.setConditions(conditionList);

        demands.setMinEngineVolume(minEV);
        demands.setMaxEngineVolume(maxEV);
        demands.setMinHorsePower(minHP);
        demands.setMaxHorsePower(maxHP);
        demands.setMinTopSpeed(minTS);
        demands.setMaxTopSpeed(maxTS);
        demands.setMinPrice(minP);
        demands.setMaxPrice(maxP);
        demandsRepo.save(demands);

        return "redirect:/demands/" + id + "/edit";
    }

    @RequestMapping(value = "/add/{c_id}", method = RequestMethod.GET)
    public String addCust(Model model, @PathVariable("c_id") Long c_id) {
        model.addAttribute("c_id", c_id);

        model.addAttribute("brands", carBrandRepo.findAll());
        model.addAttribute("colors", colorRepo.findAll());
        model.addAttribute("conditions", conditionRepo.findAll());

        return "add-demands";
    }

    @RequestMapping(value = "/{id}/remove")
    public String remove(@PathVariable("id") Long id) {
        try {
            customQueryRepo.query("DELETE FROM CustomerDemands WHERE id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/customers/all";
    }

    @RequestMapping(value = "/add/{c_id}", method = RequestMethod.POST)
    public String saveDemands(@PathVariable("c_id") long c_id,
                                @RequestParam("brands") String[] brands,
                                @RequestParam("colors") String[] colors,
                                @RequestParam("conditions") String[] conditions,
                                @RequestParam("minEV") int minEV,
                                @RequestParam("maxEV") int maxEV,
                                @RequestParam("minHP") int minHP,
                                @RequestParam("maxHP") int maxHP,
                                @RequestParam("minTS") int minTS,
                                @RequestParam("maxTS") int maxTS,
                                @RequestParam("minP") int minP,
                                @RequestParam("maxP") int maxP) {
        CustomerDemands demands = new CustomerDemands();

        String SQL = "SELECT * FROM CarBrand b WHERE b.name IN (";
        for (String b : brands) {
            SQL += "'" + b + "',";
        }
        SQL = SQL.substring(0,SQL.length()-1) + ")";
        System.out.println(SQL);
        List<CarBrand> brandList = entityManager.createNativeQuery(SQL, CarBrand.class).getResultList();
        demands.setBrands(brandList);

        SQL = "SELECT * FROM Color c WHERE c.name IN (";
        for (String c : colors) {
            SQL += "'" + c + "',";
        }
        SQL = SQL.substring(0,SQL.length()-1) + ")";
        System.out.println(SQL);
        List<Color> colorList = entityManager.createNativeQuery(SQL, Color.class).getResultList();
        demands.setColors(colorList);

        SQL = "SELECT * FROM CarCondition c WHERE c.name IN (";
        for (String c : conditions) {
            SQL += "'" + c + "',";
        }
        SQL = SQL.substring(0,SQL.length()-1) + ")";
        System.out.println(SQL);
        List<CarCondition> conditionList = entityManager.createNativeQuery(SQL, CarCondition.class).getResultList();
        demands.setConditions(conditionList);

        demands.setMinEngineVolume(minEV);
        demands.setMaxEngineVolume(maxEV);
        demands.setMinHorsePower(minHP);
        demands.setMaxHorsePower(maxHP);
        demands.setMinTopSpeed(minTS);
        demands.setMaxTopSpeed(maxTS);
        demands.setMinPrice(minP);
        demands.setMaxPrice(maxP);
        demands = demandsRepo.save(demands);

        try {
            customQueryRepo.query("INSERT INTO customers_CustomerDemands VALUES (" + c_id + ", " + demands.getId() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "redirect:/customers/all";
    }

}
