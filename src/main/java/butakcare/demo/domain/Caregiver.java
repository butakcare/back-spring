package butakcare.demo.domain;

import butakcare.demo.common.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Caregiver extends CommonUser {

    private LocalDate birth;

    private String caregiverLicense;

    private String socialWorkerLicense;

    private String nursingAssistantLicense;

    private Address address;

    private String careerDescription;

    @OneToOne(mappedBy = "caregiver")
    private CaregiverCondition caregiverCondition;
}
