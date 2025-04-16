package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Senior {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = true)
    private String photo;

    private LocalDate birth;

    private String gender;

    private Integer weight;

    private Integer careRank;

    private String address;

    private String addressDetail;

    @Column(nullable = true)
    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "center_id")
    private Center center;

    public void update(
            LocalDate birth,
            String gender,
            Integer weight,
            Integer careRank,
            String address,
            String addressDetail,
            String memo
    ) {
        if (birth != null) {
            this.birth = birth;
        }
        if (gender != null) {
            this.gender = gender;
        }
        if (weight != null) {
            this.weight = weight;
        }
        if (careRank != null) {
            this.careRank = careRank;
        }
        if (address != null) {
            this.address = address;
        }
        if (addressDetail != null) {
            this.addressDetail = addressDetail;
        }
        if (memo != null) {
            this.memo = memo;
        }
    }
}
