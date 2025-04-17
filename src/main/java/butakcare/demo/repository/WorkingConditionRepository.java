package butakcare.demo.repository;

import butakcare.demo.domain.WorkingCondition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkingConditionRepository extends JpaRepository<WorkingCondition, Long> {
}
