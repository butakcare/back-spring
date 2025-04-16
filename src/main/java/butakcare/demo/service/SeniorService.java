package butakcare.demo.service;

import butakcare.demo.domain.Center;
import butakcare.demo.domain.Senior;
import butakcare.demo.dto.SeniorPatchDto;
import butakcare.demo.dto.SeniorPostDto;
import butakcare.demo.dto.SeniorResponseDto;
import butakcare.demo.repository.CenterRepository;
import butakcare.demo.repository.SeniorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SeniorService {

    private final SeniorRepository seniorRepository;
    private final CenterRepository centerRepository;

    @Transactional
    public Senior createSenior(SeniorPostDto dto) {

        Center center = centerRepository.findById(dto.getCenter_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 센터를 찾을 수 없습니다."));

        Senior senior = Senior.builder()
                .birth(dto.getBirth())
                .gender(dto.getGender())
                .weight(dto.getWeight())
                .careRank(dto.getCareRank())
                .address(dto.getAddress())
                .addressDetail(dto.getAddressDetail())
                .memo(dto.getMemo())
                .center(center)
                .build();
        seniorRepository.save(senior);
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
