package butakcare.demo.service;

import butakcare.demo.domain.Senior;
import butakcare.demo.domain.WorkingCondition;
import butakcare.demo.domain.WorkingConditionTime;
import butakcare.demo.dto.TimeRangeDto;
import butakcare.demo.dto.WorkingConditionRequestDto;
import butakcare.demo.repository.WorkingConditionRepository;
import butakcare.demo.repository.WorkingConditionTimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class WorkingConditionService {

    private final WorkingConditionRepository workingConditionRepository;
    private final WorkingConditionTimeRepository workingConditionTimeRepository;

    @Transactional
    public void updateWorkingCondition(WorkingConditionRequestDto dto, Long seniorId) {
        WorkingCondition workingCondition = workingConditionRepository.findById(seniorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 어르신의 구인 등록 정보가 존재하지 않습니다."));

        /*월요일 ~ 일요일 스케줄을 돌면서, 요청 데이터로 변경*/
        for (WorkingConditionTime time : workingCondition.getTimes()) {
            String weekday = time.getWeekday();
            TimeRangeDto timeRangeDto = dto.getWorkingTimes().get(weekday);
            if (timeRangeDto != null) {
                time.setStartTime(timeRangeDto.getStartTime());
                time.setEndTime(timeRangeDto.getEndTime());
            }
        }
    }
}
