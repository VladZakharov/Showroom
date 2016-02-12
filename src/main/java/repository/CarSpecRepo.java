package repository;

import model.car.CarSpecifications;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 19.11.15.
 */
@Repository
public interface CarSpecRepo extends JpaRepository<CarSpecifications, Long> {

    @Query("SELECT s FROM CarSpecifications s WHERE s.car.id=?1")
    CarSpecifications findByCarId(long carId);

}
