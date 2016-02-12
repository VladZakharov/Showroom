package repository;

import model.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 19.11.15.
 */
@Repository
public interface CarRepo extends JpaRepository<Car, Long> {

//    @Query("SELECT c FROM car c WHERE c.id IN " +
//            "(SELECT s.car_id FROM CarSpecifications AS s WHERE " +
//            "s.acceleration >= )")
//    List<Car> getCars(CustomerDemands d);
}
