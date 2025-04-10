package butakcare.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class WorkingCondition {

    private Integer wage;

    @ManyToOne
    private Senior senior;
}
