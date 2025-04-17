package butakcare.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public class WorkingTimeDto {

    private Map<String, TimeRangeDto> workingTimes;
}
