package mk.ukim.finki.wp.jan2025g1.web;

import mk.ukim.finki.wp.jan2025g1.model.HistoricalPeriod;

public class ArchaeologicalSiteController {

    /**
     * This method should use the "list.html" template to display all archaeological sites.
     * The method should be mapped on paths '/' and '/archaeological-sites'.
     * The arguments that this method takes are optional and can be 'null'.
     * The filtered archaeological sites that are the result of the call
     * findPage method from the ArchaeologicalSiteService should be displayed.
     * If you want to return a paginated result, you should also pass the page number and the page size as arguments.
     *
     * @param name       Filters archaeological sites whose names contain the specified text
     * @param areaSize   Filters by area size bigger than the specified value
     * @param rating     Filters by rating greater than the specified value
     * @param period     Filters by historical period
     * @param locationId Filters by location
     * @param pageNum    The page number
     * @param pageSize   The number of items per page
     * @return The view "list.html"
     */
    public String listAll(String name,
                          Double areaSize,
                          Double rating,
                          HistoricalPeriod period,
                          Long locationId,
                          Integer pageNum,
                          Integer pageSize) {
        return "";
    }

    /**
     * This method should display the "form.html" template.
     * The method should be mapped on path '/archaeological-sites/add'.
     *
     * @return The view "form.html".
     */
    public String showAdd() {
        return "";
    }

    /**
     * This method should display the "form.html" template.
     * However, in this case, all 'input' elements should be filled with the appropriate value for the archaeological site that is updated.
     * The method should be mapped on path '/archaeological-sites/edit/[id]'.
     *
     * @return The view "form.html".
     */
    public String showEdit(Long id) {
        return "";
    }

    /**
     * This method should create a new archaeological site given the arguments it takes.
     * The method should be mapped on path '/archaeological-sites'.
     * After the archaeological site is created, all archaeological sites should be displayed.
     *
     * @param name       The name of the archaeological site
     * @param areaSize   The area size
     * @param rating     The rating of the site
     * @param period     The historical period
     * @param locationId The location ID
     * @return Redirects to the list of archaeological sites
     */
    public String create(String name,
                         Double areaSize,
                         Double rating,
                         HistoricalPeriod period,
                         Long locationId) {
        return "";
    }

    /**
     * This method should update an existing archaeological site given the arguments it takes.
     * The method should be mapped on path '/archaeological-sites/[id]'.
     * After the archaeological site is updated, all archaeological sites should be displayed.
     *
     * @param id         The ID of the archaeological site to update
     * @param name       The name of the archaeological site
     * @param areaSize   The area size
     * @param rating     The rating of the site
     * @param period     The historical period
     * @param locationId The location ID
     * @return Redirects to the list of archaeological sites
     */
    public String update(Long id,
                         String name,
                         Double areaSize,
                         Double rating,
                         HistoricalPeriod period,
                         Long locationId) {
        return "";
    }

    /**
     * This method should delete the archaeological site that has the appropriate identifier.
     * The method should be mapped on path '/archaeological-sites/delete/[id]'.
     * After the archaeological sites is deleted, all archaeological sites should be displayed.
     *
     * @param id The ID of the archaeological site to delete
     * @return Redirects to the list of archaeological sites
     */
    public String delete(Long id) {
        return "";
    }

    /**
     * This method should close the archaeological sites that has the appropriate identifier.
     * The method should be mapped on path '/archaeological-sites/close/[id]'.
     * After the selected archaeological site is closed, all archaeological sites should be displayed.
     *
     * @param id The ID of the archaeological site to close
     * @return Redirects to the list of archaeological sites
     */
    public String close(Long id) {
        return "";
    }
}

