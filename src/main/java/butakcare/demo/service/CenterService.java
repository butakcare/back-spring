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
        Address address = new Address(
                dto.getAddress().getAddress(),
                dto.getAddress().getAddressDetail()
        );

        Center center = new Center(
                dto.getName(),
                dto.getBrn(),
                dto.getPhoneNumber(),
                dto.getBathingVehicle(),
                address,
                dto.getRank(),
                dto.getStartDate(),
                dto.getSiteUrl()
        );

        centerRepository.save(center);

        return dto;
    }
}
