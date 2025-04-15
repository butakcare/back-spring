package butakcare.demo.dto;

import butakcare.demo.common.Address;
import butakcare.demo.common.Rank;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CenterRequestDto {
    private String name;
    private String brn; //사업자 번호
    private String siteUrl;
    private String phoneNumber;
    private Boolean bathingVehicle;
    private AddressDto address;
    private Rank rank;
    private LocalDate startDate;
}
