package stock.data;

import stock.data.api.Stocks;
import stock.data.models.Company;

/**
 * Created by stevenbraham on 16-04-17.
 */
public class Main {
    public static void main(String[] args) {
        //check args
        if (args.length != 1) {
            throw new IllegalArgumentException("Please provide a stock symbol");
        }
        //initialize api
        Stocks stocksApi = new Stocks();
        //do lookup
        Company company = stocksApi.lookup(args[0]);
        //print results
        System.out.println(company.name);
        System.out.println(company.exchange);
        System.out.println(company.stockPrice);
    }
}
