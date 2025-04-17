package butakcare.demo.repository;

import butakcare.demo.domain.CaregiverConditionTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaregiverConditionTimeRepository extends JpaRepository<CaregiverConditionTime, Long> {
}
