package controller;

import model.car.*;
import model.customer.Customer;
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

/**
 * Created by vlad on 19.11.15.
 */
@Controller
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    CarRepo carRepo;

    @Autowired
    CarBrandRepo carBrandRepo;

    @Autowired
    ConditionRepo conditionRepo;

    @Autowired
    ColorRepo colorRepo;

    @Autowired
    CarSpecRepo carSpecRepo;

    @Autowired
    DemandsRepo demandsRepo;

    @PersistenceContext
    EntityManager entityManager;

    CustomQueryRepo customQueryRepo = new CustomQueryRepo();

//    ChoiceService choiceService = new ChoiceService();

    @RequestMapping(value = "/all")
    public String getAllCars(Model model) {
        model.addAttribute("cars", carRepo.findAll());
        return "cars";
    }

    @RequestMapping(value = "/find/{id}")
    public String findCars(@PathVariable("id") Long demandsId, Model model) {
        CustomerDemands d = demandsRepo.findOne(demandsId);
        if (d == null) return "/404";
        List<Car> cars = getCars(d);
        model.addAttribute("cust_id", ((Customer) entityManager.createNativeQuery("select * from customers c where c.id in (select cd.customers_id from customers_CustomerDemands cd where cd.demands_id=" + d.getId() + ")", Customer.class).getSingleResult()).getId());
        model.addAttribute("cars", cars);
        return "cars";
    }

    @RequestMapping(value = "/{id}")
    public String getCar(@PathVariable("id") long id, Model model) {
//        Car car = carRepo.findOne(id);
//        model.addAttribute("car", car);
        return "car";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editCar(@PathVariable("id") long id, Model model) {
        Car car = carRepo.findOne(id);
        model.addAttribute("car", car);

        List<CarBrand> brands = carBrandRepo.findAll();
        model.addAttribute("brands", brands);

        List<CarCondition> conditions = conditionRepo.findAll();
        model.addAttribute("conditions", conditions);

        CarSpecifications spec = carSpecRepo.findByCarId(car.getId());
        model.addAttribute("spec", spec);

        List<Color> colors = colorRepo.findAll();
        model.addAttribute("colors", colors);
        return "edit-car";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String updateCar(@PathVariable("id") long id,
                            @RequestParam("brand") long brand_id,
                            @RequestParam("color") long color_id,
                            @RequestParam("tc") long condition_id,
                            @RequestParam("year") String year,
                            @RequestParam("price") String price,
                            @RequestParam("acc") String acc,
                            @RequestParam("ev") String ev,
                            @RequestParam("hp") String hp,
                            @RequestParam("ts") String ts,
                            @RequestParam("extras") String extras) {
        Car car = carRepo.findOne(id);
        if (car != null) {
            car.setBrand(carBrandRepo.findOne(brand_id));
            car.setCondition(conditionRepo.findOne(condition_id));
            car.setExtras(extras);
            car.setGraduationYear(Integer.parseInt(year));
            car.setPrice(Integer.parseInt(price));
            carRepo.save(car);
        }
        CarSpecifications spec = carSpecRepo.findByCarId(id);
        if (spec != null) {
            spec.setAcceleration(Float.parseFloat(acc.replace(',', '.')));
            spec.setColor(colorRepo.findOne(color_id));
            spec.setEngineVolume(Integer.parseInt(ev));
            spec.setHorsePowers(Integer.parseInt(hp));
            spec.setTopSpeed(Integer.parseInt(ts));
            carSpecRepo.save(spec);
        }

        return "redirect:/cars/" + id + "/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCar(Model model) {

        List<CarBrand> brands = carBrandRepo.findAll();
        model.addAttribute("brands", brands);

        List<CarCondition> conditions = conditionRepo.findAll();
        model.addAttribute("conditions", conditions);

        List<Color> colors = colorRepo.findAll();
        model.addAttribute("colors", colors);
        return "add-car";
    }

    @RequestMapping(value = "/{id}/remove")
    public String removeCar(@PathVariable("id") Long id) {
        try {
            customQueryRepo.query("DELETE FROM CarSpecifications WHERE car_id=" + id);
            customQueryRepo.query("DELETE FROM cars WHERE id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/cars/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveCar(@RequestParam("brand") long brand_id,
                          @RequestParam("color") long color_id,
                          @RequestParam("tc") long condition_id,
                          @RequestParam("year") String year,
                          @RequestParam("price") String price,
                          @RequestParam("acc") String acc,
                          @RequestParam("ev") String ev,
                          @RequestParam("hp") String hp,
                          @RequestParam("ts") String ts,
                          @RequestParam("extras") String extras) {
//        Car car = new Car();
//        car.setBrand(carBrandRepo.findOne(brand_id));
//        car.setCondition(conditionRepo.findOne(condition_id));
//        car.setExtras(extras);
//        car.setGraduationYear(Integer.parseInt(year));
//        car.setPrice(Integer.parseInt(price));
//        car = carRepo.save(car);
//
//        CarSpecifications spec = new CarSpecifications();
//        spec.setCar(car);
//        spec.setAcceleration(Float.parseFloat(acc.replace(',', '.')));
//        spec.setColor(colorRepo.findOne(color_id));
//        spec.setEngineVolume(Integer.parseInt(ev));
//        spec.setHorsePowers(Integer.parseInt(hp));
//        spec.setTopSpeed(Integer.parseInt(ts));
//        carSpecRepo.save(spec);

        long id;
        try {
            id = customQueryRepo.execute("EXEC addCar "
                    + "'" + brand_id + "', "
                    + "'" + color_id + "', "
                    + "'" + condition_id + "', "
                    + "'" + year + "', "
                    + "'" + price + "', "
                    + "'" + acc + "', "
                    + "'" + ev + "', "
                    + "'" + hp + "', "
                    + "'" + ts + "', "
                    + "'" + extras + "'"
            ).getId()[0];
        } catch (SQLException e) {
            e.printStackTrace();
            return "404";
        }

        return "redirect:/cars/" + id + "/edit";
    }

    public List<Car> getCars(CustomerDemands d) {
        return getCars(
                d.getMinTopSpeed(), d.getMaxTopSpeed(),
                d.getMinPrice(), d.getMaxPrice(),
                d.getMinHorsePower(), d.getMaxHorsePower(),
                d.getMinEngineVolume(), d.getMaxEngineVolume());
    }

    public List<Car> getCars(
            Integer minTS, Integer maxTS,
            Integer minP, Integer maxP,
            Integer minHP, Integer maxHP,
            Integer minEV, Integer maxEV
    ) {
        String SQL = "SELECT * FROM cars AS c WHERE c.id IN " +
                "(SELECT s.car_id FROM CarSpecifications AS s";
        boolean first = true;
        if (minTS != null) {
            if (!first) {
                SQL += " AND";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.topSpeed >= " + minTS;
        }
        if (maxTS != null) {
            if (!first) {
                SQL += " AND";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.topSpeed <= " + maxTS;
        }
        if (minHP != null) {
            if (!first) {
                SQL += " AND";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.horsePowers >= " + minHP;
        }
        if (maxHP != null) {
            if (!first) {
                SQL += " AND";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.horsePowers <= " + maxHP;
        }
        if (minEV != null) {
            if (!first) {
                SQL += " AND";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.engineVolume >= " + minEV;
        }
        if (maxEV != null) {
            if (!first) {
                SQL += " AND";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.engineVolume <= " + maxEV;
        }
        SQL += ")";
        first = true;
        if (minP != null) {
            SQL += " AND c.price >= " + minP;
        }
        if (maxP != null) {
            SQL += " AND c.price <= " + maxP;
        }
        return entityManager.createNativeQuery(SQL, Car.class).getResultList();
    }

}
