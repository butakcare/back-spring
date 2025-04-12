package butakcare.demo.domain;

import butakcare.demo.common.Address;
import butakcare.demo.common.Rank;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private Address address;

    private Rank rank;

    private LocalDate startDate;

    @OneToMany(mappedBy = "center", cascade = CascadeType.PERSIST)
    private List<Senior> seniorList = new ArrayList<>();
}
