package butakcare.demo.dto;

import butakcare.demo.domain.Caregiver;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class CaregiverConditionPostDto {

    private String gender;
    private Boolean hasCar;
    private Boolean hasDementiaTraining;
    private Integer minWage;
    private Integer maxWage;
}
