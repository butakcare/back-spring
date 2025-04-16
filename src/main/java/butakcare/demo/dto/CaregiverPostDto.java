package butakcare.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CaregiverPostDto {

    private String name;
    private String password;
    private String phoneNumber;
    private LocalDate birth;
    private String caregiverLicense;
    private String socialWorkerLicense;
    private String nursingAssistantLicense;
    private String address;
    private String addressDetail;

    //nullable
    private String careerDescription;
}
