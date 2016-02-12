package repository;

import model.car.CarCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 19.11.15.
 */
@Repository
public interface ConditionRepo extends JpaRepository<CarCondition, Long> {

}
