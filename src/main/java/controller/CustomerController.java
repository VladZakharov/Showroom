package controller;

/**
 * Created by vlad on 19.11.15.
 */

import model.car.Car;
import model.car.CarOrder;
import model.customer.Customer;
import model.customer.CustomerDemands;
import model.customer.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import repository.CustInfoRepo;
import repository.CustomQueryRepo;
import repository.CustomerRepo;
import repository.DemandsRepo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    CustInfoRepo custInfoRepo;

    @Autowired
    DemandsRepo demandsRepo;

    @PersistenceContext
    EntityManager entityManager;

    CustomQueryRepo customQueryRepo = new CustomQueryRepo();

    @RequestMapping(value = "/all")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerRepo.findAll());
        return "customers";
    }

    @RequestMapping(value = "orders/all")
    public String getOrders(Model model) {
        model.addAttribute("orders", entityManager.createNativeQuery("select * from CarOrder", CarOrder.class).getResultList());
        return "orders";
    }

    @RequestMapping(value = "/orders/{id}")
    public String showOrder(@PathVariable("id") long id, Model model) {
        CarOrder order = (CarOrder) entityManager.createNativeQuery("select * from CarOrder where id=" + id, CarOrder.class).getSingleResult();
        model.addAttribute("car", entityManager.createNativeQuery("select * from cars where id=" + order.getCar().getId(), Car.class).getSingleResult());
        model.addAttribute("customer", entityManager.createNativeQuery("select * from customers where id=" + order.getCust().getId(), Customer.class).getSingleResult());
        return "order";
    }

    @RequestMapping(value = "/orders/{id}/close")
    public String closeOrder(@PathVariable("id") long id, Model model) {
        try {
            customQueryRepo.execute("delete from CarOrder where id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
            return "404";
        }
        return "redirect:/customers/orders/all";
    }

    @RequestMapping(value = "/{id}")
    public String getCustomer(@PathVariable("id") long id, Model model) {
        Customer customer = customerRepo.findOne(id);
        model.addAttribute("cust", customer);
        return "customer";
    }

    @RequestMapping(value = "/{id}/order/{car_id}")
    public String createOrder(@PathVariable("id") long id, @PathVariable("car_id") long car_id, Model model) {
        long order_id;
        try {
            order_id = customQueryRepo.execute("insert into CarOrder (car_id, cust_id) output inserted.id values (" + car_id + ", " + id + ")").getId()[0];
        } catch (SQLException e) {
            e.printStackTrace();
            return "404";
        }
        return "redirect:/customers/orders/all";
    }

    @RequestMapping(value = "/{id}/demands")
    public String getDemands(@PathVariable("id") long id, Model model) {
        String SQL = "SELECT * FROM CustomerDemands d WHERE d.id IN (SELECT cd.demands_id FROM customers_CustomerDemands cd WHERE cd.customers_id=" + id + ")";
        List<CustomerDemands> demands = entityManager.createNativeQuery(SQL, CustomerDemands.class).getResultList();
        model.addAttribute("demands", demands);
        model.addAttribute("cust_id", id);
        return "demands";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String editCust(@PathVariable("id") long id, Model model) {
        Customer cust = customerRepo.findOne(id);
        model.addAttribute("cust", cust);
        return "edit-cust";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String updateCar(@PathVariable("id") long id,
                            @RequestParam("fn") String fn,
                            @RequestParam("mn") String mn,
                            @RequestParam("ln") String ln,
                            @RequestParam("mobile") String mobile) {
        Customer cust = customerRepo.findOne(id);
        if (cust != null) {
            cust.setFirstName(fn);
            cust.setMiddleName(mn);
            cust.setLastName(ln);
            cust = customerRepo.save(cust);
            CustomerInfo info = cust.getInfo();
            info.setMobile(mobile);
            custInfoRepo.save(info);
        }

        return "redirect:/customers/" + id + "/edit";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addCust(Model model) {
        return "add-cust";
    }

    @RequestMapping(value = "/{id}/remove")
    public String removeCust(@PathVariable("id") Long id) {
        try {
//            customQueryRepo.query("DELETE FROM CustomerDemands WHERE id IN (SELECT c_cd.demands_id FROM customers_CustomerDemands c_cd WHERE c_cd.customers_id=" + id + ")");
            customQueryRepo.query("DELETE FROM customers WHERE id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/customers/all";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String saveCar(@RequestParam("fn") String fn,
                          @RequestParam("mn") String mn,
                          @RequestParam("ln") String ln,
                          @RequestParam("mobile") String mobile) {
//        Customer cust = new Customer();
//        cust.setFirstName(fn);
//        cust.setMiddleName(mn);
//        cust.setLastName(ln);
//        CustomerInfo info = new CustomerInfo();
//        info.setMobile(mobile);
//        info = custInfoRepo.save(info);
//        cust.setInfo(info);
//        cust = customerRepo.save(cust);

        long id;
        try {
            id = customQueryRepo.execute("EXEC addCust "
                    + "'" + fn + "', "
                    + "'" + mn + "', "
                    + "'" + ln + "', "
                    + "'" + mobile + "'"
            ).getId()[0];
        } catch (SQLException e) {
            e.printStackTrace();
            return "404";
        }

        return "redirect:/customers/" + id + "/edit";
    }

}
