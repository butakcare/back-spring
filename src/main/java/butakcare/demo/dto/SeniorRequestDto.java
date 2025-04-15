package butakcare.demo.dto;

import butakcare.demo.common.Address;
import butakcare.demo.domain.Center;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class SeniorRequestDto {

    private String photo;
    private LocalDate birth;
    private String gender;
    private Integer weight;
    private Integer careRank;
    private AddressDto address;
    private Long center_id;

    // nullable
    private String schedule;
    private String memo;
}
