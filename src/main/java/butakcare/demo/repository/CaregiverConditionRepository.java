package butakcare.demo.repository;

import butakcare.demo.domain.CaregiverCondition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CaregiverConditionRepository extends JpaRepository<CaregiverCondition, Long> {
}
