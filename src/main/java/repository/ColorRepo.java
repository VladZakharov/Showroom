package repository;

import model.car.Color;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 19.11.15.
 */
@Repository
public interface ColorRepo extends JpaRepository<Color, Long> {

    @Query("SELECT COUNT(c) FROM Color c")
    int getCount();

}
