package butakcare.demo.service;

import butakcare.demo.domain.Center;
import butakcare.demo.domain.Senior;
import butakcare.demo.domain.WorkingCondition;
import butakcare.demo.domain.WorkingConditionTime;
import butakcare.demo.dto.SeniorPatchDto;
import butakcare.demo.dto.SeniorPostDto;
import butakcare.demo.dto.SeniorResponseDto;
import butakcare.demo.repository.CenterRepository;
import butakcare.demo.repository.SeniorRepository;
import butakcare.demo.repository.WorkingConditionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SeniorService {

    private final SeniorRepository seniorRepository;
    private final CenterRepository centerRepository;
    private final WorkingConditionRepository workingConditionRepository;

    @Transactional
    public Senior createSenior(SeniorPostDto dto) {

        Center center = centerRepository.findById(dto.getCenterId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 센터를 찾을 수 없습니다."));

        Senior senior = new Senior(
                dto.getBirth(),
                dto.getGender(),
                dto.getWeight(),
                dto.getCareRank(),
                dto.getAddress(),
                dto.getAddressDetail(),
                dto.getMemo(),
                center
        );
        seniorRepository.save(senior);

        WorkingCondition workingCondition = new WorkingCondition(senior);

        String[] weekdays = {"월", "화", "수", "목", "금", "토", "일"};
        for (String weekday : weekdays) {
            WorkingConditionTime time = new WorkingConditionTime();
            time.setWeekday(weekday);
            time.setStartTime(null);
            time.setEndTime(null);
            workingCondition.addTimes(time);
        }
        workingConditionRepository.save(workingCondition);

        return senior;
    }

    public List<SeniorResponseDto> getCenterSeniors(Long centerId) {
        Center center = centerRepository.findById(centerId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 센터를 찾을 수 없습니다."));

        List<Senior> seniors = seniorRepository.findByCenter(center);
        return seniors.stream().map(senior -> SeniorResponseDto.builder()
                .id(senior.getId())
                .photo(senior.getPhoto())
                .birth(senior.getBirth())
                .gender(senior.getGender())
                .weight(senior.getWeight())
                .careRank(senior.getCareRank())
                .address((senior.getAddress()))
                .addressDetail(senior.getAddressDetail())
                .centerId(centerId)
                .memo(senior.getMemo())
                .build()
        ).toList();
    }

    @Transactional
    public void updateSenior(Long seniorId, SeniorPatchDto dto) {
        Senior senior = seniorRepository.findById(seniorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 어르신을 찾을 수 없습니다."));
        senior.update(
                dto.getBirth(),
                dto.getGender(),
                dto.getWeight(),
                dto.getCareRank(),
                dto.getAddress(),
                dto.getAddressDetail(),
                dto.getMemo()
        );
    }
}
