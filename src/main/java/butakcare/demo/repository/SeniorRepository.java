package butakcare.demo.repository;

import butakcare.demo.domain.Center;
import butakcare.demo.domain.Senior;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeniorRepository extends JpaRepository<Senior, Long> {
    List<Senior> findByCenter(Center center);
}
