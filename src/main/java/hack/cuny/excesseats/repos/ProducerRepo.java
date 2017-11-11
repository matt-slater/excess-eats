package hack.cuny.excesseats.repos;


import hack.cuny.excesseats.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProducerRepo extends JpaRepository<Producer, Long> {
    List<Producer> findAll();
    Optional<Producer> findByName(String name);
    Producer findById(long id);

}
