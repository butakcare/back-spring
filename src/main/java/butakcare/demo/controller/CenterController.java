package butakcare.demo.controller;

import butakcare.demo.domain.Center;
import butakcare.demo.dto.CenterDto;
import butakcare.demo.service.CenterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/centers")
@RequiredArgsConstructor
public class CenterController {

    private final CenterService centerService;

    @PostMapping
    public ResponseEntity<CenterDto> createCenter(@RequestBody CenterDto dto) {
        CenterDto savedCenter = centerService.createCenter(dto);
        return ResponseEntity.ok(savedCenter);
    }
}
