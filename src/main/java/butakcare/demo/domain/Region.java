package butakcare.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Region {

    @Id
    private String regionId;

    private String sido;

    private String sigungu;

    private String eupmyeondong;

    private Float latitude;

    private Float longitude;

    @OneToMany(mappedBy = "region")
    private List<CaregiverConditionRegion> caregiverConditionRegionList = new ArrayList<>();
}
