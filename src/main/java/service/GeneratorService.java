package service;

import model.car.*;
import model.customer.Customer;
import model.customer.CustomerDemands;
import model.customer.CustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.*;
import service.generator.Generator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 19.11.15.
 */
@Service
public class GeneratorService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    DemandsRepo demandsRepo;
    @Autowired
    CarSpecRepo carSpecRepo;
    @Autowired
    ContactsRepo contactsRepo;
    @Autowired
    ColorRepo colorRepo;
    @Autowired
    ConditionRepo conditionRepo;
    @Autowired
    CarRepo carRepo;
    @Autowired
    CarBrandRepo carBrandRepo;
    private String[] firstNames = new String[]{
            "Владимир",
            "Олег",
            "Артем",
            "Слава",
            "Руслан",
            "Кирилл",
            "Анатолий",
            "Сергей",
            "Дмитрий",
            "Никита",
            "Салават",
            "Александр",
            "Миша",
            "Гена",
    };
    private String[] middleNames = new String[]{
            "Александрович",
            "Михайлович",
            "Вадимович",
            "Олегович",
            "Русланович",
            "Кириллович",
    };
    private String[] lastNames = new String[]{
            "Пирожков",
            "Трусин",
            "Панамов",
            "Некрасов",
            "Утрыгин",
            "Штанов",
    };

    public static void main(String[] args) {
        GeneratorService gService = new GeneratorService();
        gService.customers(100);
        gService.cars(5000);
    }

    private Color randomColor() {
        List<Color> colors = colorRepo.findAll();
        return colors.get(Generator.genInt(0, colors.size()));
    }

    private CarCondition randomCondition() {
        List<CarCondition> carConditions = conditionRepo.findAll();
        return carConditions.get(Generator.genInt(0, carConditions.size()));
    }

    private CarBrand randomBrand() {
        List<CarBrand> carBrands = carBrandRepo.findAll();
        return carBrands.get(Generator.genInt(0, carBrands.size()));
    }

    public CarSpecifications spec(Car car) {
        CarSpecifications specifications = new CarSpecifications(
                car,
                Generator.genInt(1500, 6000),
                Generator.genInt(90, 390),
                Generator.genFloat(2.8f, 17.9f),
                Generator.genInt(60, 890),
                randomColor());
        return specifications;
    }

    public Car car() {
        Car car = new Car(randomBrand(), Generator.genInt(1970, 2015), "<<<extras>>>", randomCondition(), Generator.genInt(50000, 10000000));
        carRepo.save(car);
        CarSpecifications spec = spec(car);
        carSpecRepo.save(spec);
        return car;
    }

    public Customer customer() {
        CustomerInfo contacts = contacts();
        contactsRepo.save(contacts);
        List<CustomerDemands> demands = demands();
        demandsRepo.save(demands);
        Customer c = new Customer(firstName(), middleName(), lastName(), contacts, demands);
        customerRepo.save(c);
        return c;
    }

    private String firstName() {
        return firstNames[Generator.genInt(0, firstNames.length - 1)];
    }

    private String middleName() {
        return middleNames[Generator.genInt(0, middleNames.length - 1)];
    }

    private String lastName() {
        return lastNames[Generator.genInt(0, lastNames.length - 1)];
    }

    public List cars(int n) {
        List cars = new ArrayList<Car>(n);
        for (int i = 0; i < n; i++) {
            cars.add(car());
        }
        return cars;
    }

    public List customers(int n) {
        List customers = new ArrayList<Customer>(n);
        for (int i = 0; i < n; i++) {
            customers.add(customer());
        }
        return customers;
    }

    private CustomerInfo contacts() {
        return new CustomerInfo(mobile());
    }

    private String mobile() {
        String mobile = "+";
        mobile += (int) (10 * Math.random());
        mobile += "(" + (int) (1000 * Math.random()) + ")";
        mobile += " " + (int) (1000 * Math.random());
        mobile += "-" + (int) (100 * Math.random());
        mobile += "-" + (int) (100 * Math.random());
        return mobile;
    }

    public List<CustomerDemands> demands() {
        List<CustomerDemands> demands = new ArrayList<>();
        int n = Generator.genInt(1, 4);
        for (int i = 0; i < n; i++) {
            demands.add(
                    new CustomerDemands(brands(), colors(), conditions(),
                            Generator.genInt(400, 1200), Generator.genInt(2000, 3000),
                            Generator.genInt(70, 130), Generator.genInt(290, 890),
                            Generator.genInt(130, 230), Generator.genInt(240, 320),
                            Generator.genInt(70000, 420000), Generator.genInt(570000, 7000000)
                    )
            );
        }
        demandsRepo.save(demands);
        return demands;
    }

    private ArrayList<CarBrand> brands() {
        List<CarBrand> carBrands = carBrandRepo.findAll();
        int n = 1 + (int) ((carBrands.size() - 2) * Math.random());
        ArrayList<CarBrand> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int r = Generator.genInt(0, carBrands.size());
            result.add(carBrands.get(r));
            carBrands.remove(r);
        }
        return result;
    }

    private ArrayList<Color> colors() {
        List<Color> colors = colorRepo.findAll();
        int n = 1 + (int) ((colors.size() - 2) * Math.random());
        ArrayList<Color> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int r = Generator.genInt(0, colors.size());
            result.add(colors.get(r));
            colors.remove(r);
        }
        return result;
    }

    private ArrayList<CarCondition> conditions() {
        int n = 1 + (int) (2 * Math.random());
        ArrayList<CarCondition> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            result.add(randomCondition());
        }

        return result;
    }

}
