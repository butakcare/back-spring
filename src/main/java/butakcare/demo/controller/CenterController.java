package butakcare.demo.controller;

import butakcare.demo.domain.Center;
import butakcare.demo.dto.CenterRequestDto;
import butakcare.demo.dto.CenterResponseDto;
import butakcare.demo.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v2/centers")
@RequiredArgsConstructor
public class CenterController {

    private final CenterService centerService;

    @PostMapping
    public ResponseEntity<Void> createCenter(@RequestBody CenterRequestDto dto) {
        Center savedCenter = centerService.createCenter(dto);

        URI location = URI.create("/api/v2/centers/" + savedCenter.getId());
        return ResponseEntity.created(location).build();
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
