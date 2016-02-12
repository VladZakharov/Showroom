package repository;

import model.customer.CustomerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 19.11.15.
 */
@Repository
public interface CustInfoRepo extends JpaRepository<CustomerInfo, Long> {

}
