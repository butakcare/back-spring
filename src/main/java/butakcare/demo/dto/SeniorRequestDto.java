package butakcare.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class SeniorRequestDto {

    private LocalDate birth;
    private String gender;
    private Integer weight;
    private Integer careRank;
    private String address;
    private String addressDetail;
    private Long center_id;

    // nullable
    private String memo;
}
