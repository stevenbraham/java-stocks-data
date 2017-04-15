package stock.data.api;

import org.apache.commons.io.IOUtils;
import stock.data.models.Company;

import java.net.URL;

/**
 * Small api class for the markit on demand api
 */
public class Stocks {
    private String apiUrl = "http://dev.markitondemand.com/MODApis/Api/v2/";

    /**
     * Retrieves basic data on an US company from market on demand
     *
     * @param stockSymbol a 3/4 letter code for the company stock symbol
     * @return a company object
     */
    public Company lookup(String stockSymbol) {
        try {
            String body = IOUtils.toString(new URL("http://dev.markitondemand.com/MODApis/Api/v2/Lookup/json?input=GOOG"));
            System.out.println(body);
        } catch (Exception e) {

        }
        return new Company();
    }
}
