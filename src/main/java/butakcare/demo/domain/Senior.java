package butakcare.demo.domain;

import butakcare.demo.common.Address;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
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

    @Column(nullable = true)
    private String schedule;

    @Column(nullable = true)
    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id")
    private Center center;
}
