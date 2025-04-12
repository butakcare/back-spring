package butakcare.demo.domain;

import butakcare.demo.common.MatchingStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Matching {

    @Id @GeneratedValue
    private Long id;

    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    private MatchingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    private CaregiverCondition caregiverCondition;

    @ManyToOne(fetch = FetchType.LAZY)
    private WorkingCondition workingCondition;
}
