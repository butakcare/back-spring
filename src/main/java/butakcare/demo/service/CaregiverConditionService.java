package butakcare.demo.service;

import butakcare.demo.domain.Caregiver;
import butakcare.demo.domain.CaregiverCondition;
import butakcare.demo.domain.CaregiverConditionTime;
import butakcare.demo.dto.CaregiverConditionPostDto;
import butakcare.demo.dto.CaregiverConditionTimeDto;
import butakcare.demo.dto.TimeRangeDto;
import butakcare.demo.repository.CaregiverConditionRepository;
import butakcare.demo.repository.CaregiverConditionTimeRepository;
import butakcare.demo.repository.CaregiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CaregiverConditionService {

    private final CaregiverConditionRepository caregiverConditionRepository;
    private final CaregiverConditionTimeRepository caregiverConditionTimeRepository;

    @Transactional
    public CaregiverCondition createWorkCondition(CaregiverConditionPostDto dto, Caregiver caregiver) {
        CaregiverCondition caregiverCondition = new CaregiverCondition(
                dto.getGender(),
                dto.getHasCar(),
                dto.getHasDementiaTraining(),
                dto.getMinWage(),
                dto.getMaxWage(),
                caregiver
        );

        String[] weekdays = {"월", "화", "수", "목", "금", "토", "일"};

        for (String weekday : weekdays) {
            CaregiverConditionTime time = new CaregiverConditionTime();
            time.setWeekday(weekday);
            time.setStartTime(null);
            time.setEndTime(null);

            caregiverCondition.addTimes(time);
        }

        caregiverConditionRepository.save(caregiverCondition);
        return caregiverCondition;
    }

    @Transactional
    public void updateWorkingTimes(Long caregiverId, CaregiverConditionTimeDto dto) {
        CaregiverCondition caregiverCondition = caregiverConditionRepository.findById(caregiverId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 요양보호사의 근무 조건이 존재하지 않습니다."));

        Map<String, TimeRangeDto> inputData = dto.getWorkingTimes();

        for (CaregiverConditionTime time : caregiverCondition.getTimes()) {
            String weekDay = time.getWeekday();
            TimeRangeDto range = inputData.get(weekDay);
            time.setStartTime(range.getStartTime());
            time.setEndTime(range.getEndTime());
        }
    }
}
