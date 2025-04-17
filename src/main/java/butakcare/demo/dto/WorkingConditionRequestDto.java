package butakcare.demo.dto;

import butakcare.demo.domain.Region;
import butakcare.demo.domain.Senior;
import butakcare.demo.domain.WorkingConditionTime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
public class WorkingConditionRequestDto {

    private Integer wage;
    private Long region_id;
    private Map<String, TimeRangeDto> workingTimes;
}
