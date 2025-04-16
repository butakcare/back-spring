package butakcare.demo.service;

import butakcare.demo.domain.Center;
import butakcare.demo.dto.CenterRequestDto;
import butakcare.demo.dto.CenterResponseDto;
import butakcare.demo.repository.CenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CenterService {

    private final CenterRepository centerRepository;

    @Transactional
    public Center createCenter(CenterRequestDto dto) {
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
        return center;
    }

    public List<CenterResponseDto> allCenters() {
        List<Center> centers = centerRepository.findAll();
        return centers.stream().map(center -> new CenterResponseDto(
                center.getId(),
                center.getName(),
                center.getBrn(),
                center.getPhoneNumber(),
                center.getBathingVehicle(),
                center.getAddress(),
                center.getAddressDetail(),
                center.getRank(),
                center.getStartDate(),
                center.getSiteUrl()
        )).toList();
    }

    public List<CenterResponseDto> searchCenters(String name) {
        List<Center> centers = centerRepository.findByNameContaining(name);
        return centers.stream().map(center -> new CenterResponseDto(
                center.getId(),
                center.getName(),
                center.getBrn(),
                center.getPhoneNumber(),
                center.getBathingVehicle(),
                center.getAddress(),
                center.getAddressDetail(),
                center.getRank(),
                center.getStartDate(),
                center.getSiteUrl()
        )).toList();
    }
}
