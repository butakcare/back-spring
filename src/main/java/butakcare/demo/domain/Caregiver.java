package butakcare.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Caregiver extends CommonUser {

    private LocalDate birth;

    private String caregiverLicense;

    @Column(nullable = true)
    private String socialWorkerLicense;

    @Column(nullable = true)
    private String nursingAssistantLicense;

    private String address;

    private String addressDetail;

    @Column(nullable = true)
    private String careerDescription;

    public Caregiver(
            String name,
            String password,
            String phoneNumber,
            LocalDate birth,
            String caregiverLicense,
            String socialWorkerLicense,
            String nursingAssistantLicense,
            String address,
            String addressDetail,
            String careerDescription
    ) {
        super(name, password, phoneNumber);
        this.birth = birth;
        this.caregiverLicense = caregiverLicense;
        this.socialWorkerLicense = socialWorkerLicense;
        this.nursingAssistantLicense = nursingAssistantLicense;
        this.address = address;
        this.addressDetail = addressDetail;
        this.careerDescription = careerDescription;
    }
}
