package butakcare.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class TimeRangeDto {

    private LocalTime startTime;
    private LocalTime endTime;
}
