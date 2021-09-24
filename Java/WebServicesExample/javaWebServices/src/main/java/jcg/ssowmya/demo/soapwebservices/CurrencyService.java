package jcg.ssowmya.demo.soapwebservices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import jcg.ssowmya.demo.currency.Currency;

import java.util.List;

@WebService
public interface CurrencyService {
    @WebMethod
    public Currency getCurrencyById(int id);

    @WebMethod
    public Currency findByCode(String code);

    @WebMethod
    public List<Currency> getAllCurrencies();

    @WebMethod
    public Currency save(Currency currency);

    @WebMethod
    public Currency deleteById(int id);
}
