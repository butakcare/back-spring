package butakcare.demo.service;

import butakcare.demo.domain.Center;
import butakcare.demo.domain.Senior;
import butakcare.demo.dto.CenterRequestDto;
import butakcare.demo.dto.SeniorRequestDto;
import butakcare.demo.repository.CenterRepository;
import butakcare.demo.repository.SeniorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SeniorService {

    private final SeniorRepository seniorRepository;
    private final CenterRepository centerRepository;

    @Transactional
    public Senior createSenior(SeniorRequestDto dto) {

        Center center = centerRepository.findById(dto.getCenter_id())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 센터를 찾을 수 없습니다."));

        Senior senior = Senior.builder()
                .photo(dto.getPhoto())
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
}
