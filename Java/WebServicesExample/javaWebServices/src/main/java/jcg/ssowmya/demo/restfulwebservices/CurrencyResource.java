package jcg.ssowmya.demo.restfulwebservices;

import jcg.ssowmya.demo.currency.Currency;
import jcg.ssowmya.demo.currency.CurrencyDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/CurrencyService")
public class CurrencyResource {
    private CurrencyDao currencyDao = new CurrencyDao();
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello!";
    }

    @GET
    @Path("/currency")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Currency> getAllCurrency() {
        return currencyDao.findAll();
    }
}
