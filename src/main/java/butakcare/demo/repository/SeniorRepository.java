package butakcare.demo.repository;

import butakcare.demo.domain.Senior;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeniorRepository extends JpaRepository<Senior, Long> {
}
