package butakcare.demo.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@NoArgsConstructor
public class Address {
    private String address;
    private String addressDetail;

    public Address(String addressDetail, String address) {
        this.address = address;
        this.addressDetail = addressDetail;
    }
}
