package butakcare.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CaregiverResponseDto {

    private Long id;
    private String name;
    private String phoneNumber;
    private String photo;
    private LocalDate birth;
    private String caregiverLicense;
    private String socialWorkerLicense;
    private String nursingAssistantLicense;
    private String address;
    private String addressDetail;
    private String careerDescription;
}
