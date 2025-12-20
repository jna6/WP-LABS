package mk.ukim.finki.wp.jan2025g1.config;

import mk.ukim.finki.wp.jan2025g1.model.HistoricalPeriod;
import mk.ukim.finki.wp.jan2025g1.model.SiteLocation;
import mk.ukim.finki.wp.jan2025g1.service.ArchaeologicalSiteService;
import mk.ukim.finki.wp.jan2025g1.service.SiteLocationService;

import java.util.List;

public class DataInitializer {

    private final ArchaeologicalSiteService archaeologicalSiteService;
    private final SiteLocationService locationService;

    public DataInitializer(ArchaeologicalSiteService archaeologicalSiteService, SiteLocationService locationService) {
        this.archaeologicalSiteService = archaeologicalSiteService;
        this.locationService = locationService;
    }

    private HistoricalPeriod randomizeHistoricalPeriod(int i) {
        if (i % 4 == 0) return HistoricalPeriod.PREHISTORIC;
        if (i % 4 == 1) return HistoricalPeriod.ANCIENT;
        if (i % 4 == 2) return HistoricalPeriod.MEDIEVAL;
        return HistoricalPeriod.RENAISSANCE;
    }

    public void initData() {
        for (int i = 1; i <= 3; i++) {
            this.locationService.create("City " + i, "Country " + i);
        }

        List<SiteLocation> locations = this.locationService.listAll();

        for (int i = 1; i <= 10; i++) {
            String name = "Archaeological Site " + i;
            Double areaSize = 500 + (i * 100.0);
            Double rating = 3.5 + (i * 0.2);
            HistoricalPeriod period = this.randomizeHistoricalPeriod(i);
            Long locationId = locations.get((i - 1) % locations.size()).getId();

            this.archaeologicalSiteService.create(name, areaSize, rating, period, locationId);
        }
    }
}
