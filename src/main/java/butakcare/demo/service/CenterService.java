package butakcare.demo.service;

import butakcare.demo.domain.Center;
import butakcare.demo.dto.CenterDto;
import butakcare.demo.repository.CenterRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional()
@RequiredArgsConstructor
public class CenterService {

    private final CenterRepository centerRepository;

    public CenterDto createCenter(CenterDto dto) {
        Center center = new Center(
                dto.getName(),
                dto.getBrn(),
                dto.getPhoneNumber(),
                dto.getBathingVehicle(),
                dto.getAddress(),
                dto.getAddressDetail(),
                dto.getRank(),
                dto.getStartDate(),
                dto.getSiteUrl()
        );

        centerRepository.save(center);

        return dto;
    }
}
