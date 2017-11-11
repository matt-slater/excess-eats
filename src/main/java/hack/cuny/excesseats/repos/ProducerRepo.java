package hack.cuny.excesseats.repos;


import hack.cuny.excesseats.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProducerRepo extends JpaRepository<Producer, Long> {
    List<Producer> findAll();
    Optional<Producer> findByName(String name);

}
