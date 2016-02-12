package repository;

import model.car.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 19.11.15.
 */
@Repository
public interface CarBrandRepo extends JpaRepository<CarBrand, Long> {


}
