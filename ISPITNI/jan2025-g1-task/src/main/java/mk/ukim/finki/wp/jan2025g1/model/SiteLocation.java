package mk.ukim.finki.wp.jan2025g1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SiteLocation {

    private Long id;
    private String city;
    private String country;

    public SiteLocation(String city, String country) {
        this.city = city;
        this.country = country;
    }
}
