package jcg.ssowmya.demo.soapwebservices.client;

import src.main.java.jcg.ssowmya.demo.jaxws.client.Currency;
import src.main.java.jcg.ssowmya.demo.jaxws.client.CurrencyService;
import src.main.java.jcg.ssowmya.demo.jaxws.client.CurrencyServiceImplService;

import java.net.URL;
import java.util.List;

public class CurrencyServiceClient {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://localhost:8080/currencyservice?wsdl");
        CurrencyServiceImplService currencyServiceImplService = new CurrencyServiceImplService(url);
        CurrencyService currencyService = currencyServiceImplService.getCurrencyServiceImplPort();
        List<Currency> currencyList = currencyService.getAllCurrencies();
        System.out.println("Number of currencies retrieved: "+currencyList.size());
    }
}
