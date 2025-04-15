package butakcare.demo.domain;

import butakcare.demo.common.Address;
import butakcare.demo.common.Rank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Center {

    @Id @GeneratedValue
    private Long id;

    private String name;

    private String brn; //사업자 번호

    @Column(nullable = true)
    private String siteUrl;

    private String phoneNumber;

    private Boolean bathingVehicle;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    private LocalDate startDate;

    @OneToMany(mappedBy = "center", cascade = CascadeType.PERSIST)
    private List<Senior> seniorList = new ArrayList<>();

    public Center(String name, String brn, String phoneNumber,
                  Boolean bathingVehicle, Address address, Rank rank, LocalDate startDate, String siteUrl) {
        this.name = name;
        this.brn = brn;
        this.phoneNumber = phoneNumber;
        this.bathingVehicle = bathingVehicle;
        this.address = address;
        this.rank = rank;
        this.startDate = startDate;
        this.siteUrl = siteUrl;
    }
}
