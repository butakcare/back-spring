package butakcare.demo.repository;

import butakcare.demo.domain.CaregiverCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaregiverConditionRepository extends JpaRepository<CaregiverCondition, Long> {
}
