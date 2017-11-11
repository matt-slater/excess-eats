package hack.cuny.excesseats.repos;

import hack.cuny.excesseats.model.Eats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EatsRepo extends JpaRepository<Eats, Long> {
    List<Eats> findAll();
    List<Eats> findByProducerId(long id);
    Eats findById(long id);
}
