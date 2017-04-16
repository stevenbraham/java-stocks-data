package stock.data.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import stock.data.exceptions.InvalidApiMethodException;
import stock.data.models.Company;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Small api class for the markit on demand api
 */
public class Stocks {

    /**
     * Retrieves basic data on an US company from market on demand
     *
     * @param stockSymbol a 3/4 letter code for the company stock symbol
     * @return a company object
     */
    public Company lookup(String stockSymbol) {
        try {
            JSONArray lookupResult = (JSONArray) doApiCall(apiMethod.COMPANY_LOOKUP, "AAPL");
            //retrieve first result from api
            return new Company();
        } catch (Exception e) {
            //return blank company on error
            return new Company();
        }
    }

    /**
     * @param apiMethod   a value from the api methods enum
     * @param quoteSymbol
     * @return json object with api data
     * @see Stocks.apiMethod-
     */
    public JSONObject doApiCall(apiMethod apiMethod, String quoteSymbol) throws InvalidApiMethodException, IOException, ParseException {
        //prepare url call
        String apiUrl = "http://dev.markitondemand.com/MODApis/Api/v2/";
        //append appropiate arguments
        switch (apiMethod) {
            case COMPANY_LOOKUP:
                apiUrl += "Quote/json?symbol=" + quoteSymbol;
                break;
            case QUOTE_LOOKUP:
                apiUrl += "Lookup/json?input=" + quoteSymbol;
                break;
            default:
                throw new InvalidApiMethodException();
        }
        //get json from url
        return (JSONObject) new JSONParser().parse(new InputStreamReader(new URL(apiUrl).openStream()));
    }

    /**
     * valid params from the doApiCall method
     */
    public enum apiMethod {
        COMPANY_LOOKUP, QUOTE_LOOKUP
    }
}
