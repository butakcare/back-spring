package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class CaregiverCondition {

    @Id @GeneratedValue
    private Long id;

    private String gender;

    private Boolean has_car;

    private Boolean has_dementia_training;

    private Integer minWage;

    private Integer maxWage;

    private LocalDateTime updatedTime;

    @OneToOne
    private Caregiver caregiver;

    @OneToMany(mappedBy = "caregiverCondition")
    private List<CaregiverConditionRegion> caregiverConditionRegionList = new ArrayList<>();
}
