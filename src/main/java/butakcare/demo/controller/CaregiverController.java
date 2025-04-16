package butakcare.demo.controller;

import butakcare.demo.domain.Caregiver;
import butakcare.demo.dto.CaregiverPostDto;
import butakcare.demo.service.CaregiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/caregivers")
public class CaregiverController {

    private final CaregiverService caregiverService;

    public ResponseEntity<Void> createCaregiver(@RequestBody CaregiverPostDto dto) {
        Caregiver savedCaregiver = caregiverService.createCaregiver(dto);
        URI location = URI.create("/api/v2/caregivers/" + savedCaregiver.getId());
        return ResponseEntity.created(location).build();
    }
}
