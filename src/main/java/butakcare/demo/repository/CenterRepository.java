package butakcare.demo.repository;

import butakcare.demo.domain.Center;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<Center, Long> {
}
