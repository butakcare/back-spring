package butakcare.demo.repository;

import butakcare.demo.domain.Center;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {
    List<Center> findByNameContaining(String name);
}
