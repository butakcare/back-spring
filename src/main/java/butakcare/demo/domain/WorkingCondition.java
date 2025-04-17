package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class WorkingCondition {

    @Id
    private Long id;

    @Column(nullable = true)
    private Integer wage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = true)
    private Region region;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id")
    private Senior senior;

    @OneToMany(mappedBy = "workingCondition", cascade = CascadeType.ALL)
    private List<WorkingConditionTime> times = new ArrayList<>();

    public WorkingCondition(
            Senior senior
    ) {
        this.wage = wage;
        this.region = region;
        this.senior = senior;
    }

    public void addTimes(WorkingConditionTime time){
        this.times.add(time);
        time.setWorkingCondition(this);
    }
}
