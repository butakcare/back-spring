package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class CaregiverCondition {

    @Id @GeneratedValue
    private Long id;

    private String gender;

    private Boolean hasCar;

    private Boolean hasDementiaTraining;

    private Integer minWage;

    private Integer maxWage;

    @LastModifiedDate
    private LocalDateTime updatedTime;

    @CreatedDate
    private LocalDateTime createdTime;

    @OneToOne
    private Caregiver caregiver;

    @OneToMany(mappedBy = "caregiverCondition", cascade = CascadeType.ALL)
    private List<CaregiverConditionRegion> regions = new ArrayList<>();

    @OneToMany(mappedBy = "caregiverCondition", cascade = CascadeType.ALL)
    private List<CaregiverConditionTime> times = new ArrayList<>();

    public CaregiverCondition(
            String gender,
            Boolean hasCar,
            Boolean hasDementiaTraining,
            Integer minWage,
            Integer maxWage,
            Caregiver caregiver
    ) {
        this.gender = gender;
        this.hasCar = hasCar;
        this.hasDementiaTraining = hasDementiaTraining;
        this.minWage = minWage;
        this.maxWage = maxWage;
        this.caregiver = caregiver;
    }

    public void addRegions(CaregiverConditionRegion region) {
        this.regions.add(region);
        region.setCaregiverCondition(this);
    }

    public void addTimes(CaregiverConditionTime time) {
        this.times.add(time);
        time.setCaregiverCondition(this);
    }

}
