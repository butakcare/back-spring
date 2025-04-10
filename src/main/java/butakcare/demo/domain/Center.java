package butakcare.demo.domain;

import butakcare.demo.common.Address;
import butakcare.demo.common.Rank;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Center {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String brn; //사업자 번호

    private String siteUrl;

    private String phoneNumber;

    private Boolean bathingVehicle;

    private Address address;

    private Rank rank;

    private LocalDate startDate;
}
