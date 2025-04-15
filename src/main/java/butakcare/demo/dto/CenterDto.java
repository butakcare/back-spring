package butakcare.demo.dto;

import butakcare.demo.common.Rank;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class CenterDto {
    private String name;
    private String brn; //사업자 번호
    private String phoneNumber;
    private Boolean bathingVehicle;
    private AddressDto address;
    private Rank rank;
    private LocalDate startDate;

    // nullable
    private String siteUrl;
}
