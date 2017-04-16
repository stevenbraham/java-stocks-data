package stock.data.api;

import junit.framework.TestCase;
import stock.data.models.Company;

/**
 * Created by stevenbraham on 16-04-17.
 */
public class StocksTest extends TestCase {
    public StocksTest(String name) {
        super(name);
    }

    public void testGetStockPriceReturnsZeroForFakeCompany() throws Exception {
        Stocks api = new Stocks();
        assertEquals(api.getStockPrice("fsjkdfkjsfsf"), 0.0);
    }

    public void testGetStockPriceReturnsRealData() throws Exception {
        Stocks api = new Stocks();
        assertTrue(api.getStockPrice("AAPL") > 10);
        assertTrue(api.getStockPrice("GOOG") > 10);
    }

    public void testLookUpReturnsErrorForFakeCompany() throws Exception {
        Stocks api = new Stocks();
        Company result = api.lookup("fsjkdfkjsfsf");
        assertEquals(result.name, "ERROR");
        assertEquals(result.stockSymbol, "ERROR");
        assertEquals(result.stockPrice, 0.0);
        assertEquals(result.exchange, "ERROR");
    }

    public void testLookupFunctionsWorks() throws Exception {
        Stocks api = new Stocks();
        Company Apple = api.lookup("AAPL");
        assertEquals(Apple.name, "Apple Inc");
        assertEquals(Apple.exchange, "NASDAQ");
    }
}
