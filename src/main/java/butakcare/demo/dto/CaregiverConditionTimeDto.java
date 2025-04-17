package butakcare.demo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;
import java.util.Map;

@Getter
@AllArgsConstructor
public class CaregiverConditionTimeDto {

    private Map<String, TimeRangeDto> workingTimes;
}
