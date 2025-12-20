package mk.ukim.finki.wp.jan2025g1.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ArchaeologicalSite {

    private Long id;
    private String name;
    private Double areaSize;
    private boolean closed = false;
    private Double rating;
    private HistoricalPeriod period;
    private SiteLocation location;

    public ArchaeologicalSite(String name, Double areaSize, boolean closed, Double rating, HistoricalPeriod period, SiteLocation location) {
        this.name = name;
        this.areaSize = areaSize;
        this.closed = closed;
        this.rating = rating;
        this.period = period;
        this.location = location;
    }

    public ArchaeologicalSite(String name, Double areaSize, Double rating, HistoricalPeriod period, SiteLocation location) {
        this.name = name;
        this.areaSize = areaSize;
        this.rating = rating;
        this.period = period;
        this.location = location;
    }
}

