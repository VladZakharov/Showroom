package repository;

import model.car.CarSpecifications;
import model.customer.CustomerDemands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by vlad on 19.11.15.
 */
@Repository
public interface DemandsRepo extends JpaRepository<CustomerDemands, Long> {

//    @Query("SELECT d FROM CustomerDemands d WHERE d.id IN (SELECT cd.demands_id FROM customers_CustomerDemands cd WHERE cd.customers_id=?1)")
//    List findByCustomerId(long id);

}
