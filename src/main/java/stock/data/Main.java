package stock.data;

import stock.data.api.Stocks;
import stock.data.models.Company;

/**
 * Created by stevenbraham on 16-04-17.
 */
public class Main {
    public static void main(String[] args) {
        //initialize api
        Stocks stocksApi = new Stocks();
        //do lookup
        Company company = stocksApi.lookup("AAPL");
        //print results
        System.out.println(company.name);
        System.out.println(company.exchange);
        System.out.println(company.stockPrice);
    }
}
