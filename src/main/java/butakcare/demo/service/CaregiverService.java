package butakcare.demo.service;

import butakcare.demo.domain.Caregiver;
import butakcare.demo.dto.CaregiverPostDto;
import butakcare.demo.repository.CaregiverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CaregiverService {

    private final CaregiverRepository caregiverRepository;

    @Transactional
    public Caregiver createCaregiver(CaregiverPostDto dto) {
        Caregiver caregiver = new Caregiver(
                dto.getName(),
                dto.getPassword(),
                dto.getPhoneNumber(),
                dto.getBirth(),
                dto.getCaregiverLicense(),
                dto.getSocialWorkerLicense(),
                dto.getNursingAssistantLicense(),
                dto.getAddress(),
                dto.getAddressDetail(),
                dto.getCareerDescription()
        );
        caregiverRepository.save(caregiver);
        return caregiver;
    }

    public Caregiver findCaregiver(Long caregiverId) {
        Caregiver caregiver = caregiverRepository.findById(caregiverId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 요양보호사를 찾을 수 없습니다."));
        return caregiver;
    }
}
