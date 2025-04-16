package butakcare.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class SeniorPatchDto {

    private LocalDate birth;
    private String gender;
    private Integer weight;
    private Integer careRank;
    private String address;
    private String addressDetail;

    // nullable
    private String memo;
}
