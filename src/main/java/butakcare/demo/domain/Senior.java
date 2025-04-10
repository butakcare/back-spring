package butakcare.demo.domain;

import butakcare.demo.common.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDate;

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

    private Address address;

    private String schedule;

    private String memo;

    @ManyToOne
    private Center center;
}
