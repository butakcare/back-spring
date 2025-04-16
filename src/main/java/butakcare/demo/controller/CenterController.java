package butakcare.demo.controller;

import butakcare.demo.domain.Center;
import butakcare.demo.dto.CenterRequestDto;
import butakcare.demo.dto.CenterResponseDto;
import butakcare.demo.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/centers")
@RequiredArgsConstructor
public class CenterController {

    private final CenterService centerService;

    @PostMapping
    public ResponseEntity<CenterRequestDto> createCenter(@RequestBody CenterRequestDto dto) {
        CenterRequestDto savedCenter = centerService.createCenter(dto);
        return ResponseEntity.ok(savedCenter);
    }

    @GetMapping
    public ResponseEntity<List<CenterResponseDto>> getCenters(@RequestParam String name) {
        List<CenterResponseDto> response;
        if (name == null || name.isEmpty()) {
            response = centerService.allCenters();
        } else {
            response = centerService.searchCenters(name);
        }
        return ResponseEntity.ok(response);
    }
}
