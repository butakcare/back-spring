package butakcare.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    private String address;

    private String addressDetail;

    private String careerDescription;

    @OneToOne(mappedBy = "caregiver", fetch = FetchType.LAZY)
    private CaregiverCondition caregiverCondition;
}
