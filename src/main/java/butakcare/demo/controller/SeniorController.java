package butakcare.demo.controller;

import butakcare.demo.domain.Senior;
import butakcare.demo.dto.SeniorRequestDto;
import butakcare.demo.service.SeniorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v2/seniors")
@RequiredArgsConstructor
public class SeniorController {

    private final SeniorService seniorService;

    @PostMapping
    public ResponseEntity<Void> createSenior(@RequestBody SeniorRequestDto dto) {
        Senior savedSenior = seniorService.createSenior(dto);
        URI location = URI.create("/api/v2/seniors/" + savedSenior.getId());
        return ResponseEntity.created(location).build();
    }
}
