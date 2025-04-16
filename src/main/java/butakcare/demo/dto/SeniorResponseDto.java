package butakcare.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
public class SeniorResponseDto {

    private Long id;
    private String photo;
    private LocalDate birth;
    private String gender;
    private Integer weight;
    private Integer careRank;
    private String address;
    private String addressDetail;
    private Long centerId;

    // nullable
    @Builder.Default
    private String memo = "";
}
