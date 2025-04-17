package butakcare.demo.controller;

import butakcare.demo.domain.Senior;
import butakcare.demo.dto.SeniorPatchDto;
import butakcare.demo.dto.SeniorPostDto;
import butakcare.demo.dto.SeniorResponseDto;
import butakcare.demo.dto.WorkingConditionRequestDto;
import butakcare.demo.service.SeniorService;
import butakcare.demo.service.WorkingConditionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v2/seniors")
@RequiredArgsConstructor
public class SeniorController {

    private final SeniorService seniorService;
    private final WorkingConditionService workingConditionService;

    @PostMapping
    public ResponseEntity<Void> createSenior(@RequestBody SeniorPostDto dto) {
        Senior savedSenior = seniorService.createSenior(dto);
        URI location = URI.create("/api/v2/seniors/" + savedSenior.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<List<SeniorResponseDto>> getSeniors(@RequestParam Long centerId) {
        List<SeniorResponseDto> response = seniorService.getCenterSeniors(centerId);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{seniorId}")
    public ResponseEntity<Void> updateSenior(@PathVariable Long seniorId, @RequestBody SeniorPatchDto dto) {
        seniorService.updateSenior(seniorId, dto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{seniorId}/matching-condition")
    public ResponseEntity<Void> setMatchingCondition(@PathVariable Long seniorId, @RequestBody WorkingConditionRequestDto dto) {
        workingConditionService.updateWorkingCondition(dto, seniorId);
        return ResponseEntity.noContent().build();
    }
}
