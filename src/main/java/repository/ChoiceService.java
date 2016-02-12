package repository;

import model.car.Car;
import model.customer.CustomerDemands;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Vlad on 18.01.2016.
 */
@Repository
public class ChoiceService {

    @PersistenceContext
    EntityManager entityManager;

//    CustomQueryRepo cqRepo = new CustomQueryRepo();

    public List<Car> getCars(CustomerDemands d) {
        return getCars(d.getMinTopSpeed(), d.getMaxTopSpeed(),
                d.getMinPrice(), d.getMaxPrice(),
                d.getMinHorsePower(), d.getMaxHorsePower(),
                d.getMinEngineVolume(), d.getMaxEngineVolume());
    }

    public List<Car> getCars(Integer minTS, Integer maxTS,
                             Integer minP, Integer maxP,
                             Integer minHP, Integer maxHP,
                             Integer minEV, Integer maxEV) {
        String SQL = "SELECT * FROM car AS c WHERE c.id IN " +
                "(SELECT s.car_id FROM CarSpecifications AS s";
        boolean first = true;
        if (minTS != null) {
            if (!first) {
                SQL += " &";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.minTopSpeed >= " + minTS;
        }
        if (maxTS != null) {
            if (!first) {
                SQL += " &";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.maxTopSpeed <= " + maxTS;
        }
        if (minP != null) {
            if (!first) {
                SQL += " &";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.minPrice >= " + minP;
        }
        if (maxP != null) {
            if (!first) {
                SQL += " &";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.maxPrice <= " + maxP;
        }
        if (minHP != null) {
            if (!first) {
                SQL += " &";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.minHorsePower >= " + minHP;
        }
        if (maxHP != null) {
            if (!first) {
                SQL += " &";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.maxHorsePower <= " + maxHP;
        }
        if (minEV != null) {
            if (!first) {
                SQL += " &";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.minEngineVolume >= " + minEV;
        }
        if (maxEV != null) {
            if (!first) {
                SQL += " &";
            } else {
                SQL += " WHERE";
                first = false;
            }
            SQL += " s.maxEngineVolume <= " + maxEV;
        }
        SQL += ")";
        return entityManager.createNativeQuery(SQL, Car.class).getResultList();
    }

//    private String add(String s, Boolean first) {
//        String result = "";
//        if (!first) {
//            result += " & ";
//        } else {
//            result += " WHERE ";
//            first = false;
//        }
//        result += s;
//        return result;
//    }

}
