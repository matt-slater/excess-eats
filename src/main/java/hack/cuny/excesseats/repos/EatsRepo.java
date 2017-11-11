package hack.cuny.excesseats.repos;

import hack.cuny.excesseats.model.Eats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EatsRepo extends JpaRepository<Eats, Long> {
    List<Eats> findAll();
}
