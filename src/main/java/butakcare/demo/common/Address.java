package butakcare.demo.common;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class Address {
    private String address;
    private String addressDetail;

    public Address(String address, String addressDetail) {
        this.address = address;
        this.addressDetail = addressDetail;
    }
}
