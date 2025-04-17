package butakcare.demo.controller;

import butakcare.demo.domain.Caregiver;
import butakcare.demo.domain.CaregiverCondition;
import butakcare.demo.dto.CaregiverConditionPostDto;
import butakcare.demo.dto.CaregiverPostDto;
import butakcare.demo.service.CaregiverConditionService;
import butakcare.demo.service.CaregiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/caregivers")
public class CaregiverController {

    private final CaregiverService caregiverService;
    private final CaregiverConditionService caregiverConditionService;

    @PostMapping
    public ResponseEntity<Void> createCaregiver(@RequestBody CaregiverPostDto dto) {
        Caregiver savedCaregiver = caregiverService.createCaregiver(dto);
        URI location = URI.create("/api/v2/caregivers/" + savedCaregiver.getId());
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/{caregiverId}/working-condition")
    public ResponseEntity<Void> createWorkCondition(@PathVariable Long caregiverId, @RequestBody CaregiverConditionPostDto dto) {
        Caregiver caregiver = caregiverService.findCaregiver(caregiverId);
        CaregiverCondition workCondition = caregiverConditionService.createWorkCondition(dto, caregiver);

        URI location = URI.create("/api/v2/caregivers/" + caregiverId);

        return ResponseEntity.created(location).build();
    }
}
