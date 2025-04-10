package butakcare.demo.domain;

import butakcare.demo.common.Address;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Senior {

    @Id @GeneratedValue
    private Long id;

    private String photo;

    private LocalDate birth;

    private String gender;

    private Integer weight;

    private Integer careRank;

    @Enumerated(EnumType.STRING)
    private Address address;

    private String schedule;

    private String memo;

    @ManyToOne
    private Center center;
}
