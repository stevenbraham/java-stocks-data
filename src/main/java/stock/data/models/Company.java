package stock.data.models;

/**
 * Object to hold company data from the api
 */
public class Company {
    public String name, stockSymbol, exchange;
    public Double stockPrice;

    public Company(String name, String stockSymbol, String exchange, Double stockPrice) {
        this.name = name;
        this.stockSymbol = stockSymbol;
        this.exchange = exchange;
        this.stockPrice = stockPrice;
    }
}
