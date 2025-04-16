package butakcare.demo.controller;

import butakcare.demo.domain.Senior;
import butakcare.demo.dto.SeniorPatchDto;
import butakcare.demo.dto.SeniorPostDto;
import butakcare.demo.dto.SeniorResponseDto;
import butakcare.demo.service.SeniorService;
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
    public ResponseEntity<SeniorPatchDto> updateSenior(@PathVariable Long seniorId, @RequestBody SeniorPatchDto dto) {
        seniorService.updateSenior(seniorId, dto);
        return ResponseEntity.noContent().build();
    }
}
