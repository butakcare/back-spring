package butakcare.demo.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class WorkingCondition {

    @Id @GeneratedValue
    private Long id;

    private Integer wage;

    @OneToOne(fetch = FetchType.LAZY)
    private Region region;

    @ManyToOne(fetch = FetchType.LAZY)
    private Senior senior;

    @OneToMany(mappedBy = "workingCondition", cascade = CascadeType.ALL)
    private List<WorkingConditionTime> times = new ArrayList<>();

    public void setSenior(Senior senior){
        this.senior = senior;
    }

    public void addTimes(WorkingConditionTime time){
        this.times.add(time);
        time.setWorkingCondition(this);
    }
}
