package jcg.ssowmya.demo.soapwebservices;

import jcg.ssowmya.demo.currency.Currency;
import jcg.ssowmya.demo.currency.CurrencyDao;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "jcg.ssowmya.demo.soapwebservices.CurrencyService")
public class CurrencyServiceImpl implements CurrencyService{
    private static CurrencyDao currencyDao;
    static {
        currencyDao = new CurrencyDao();
    }

    @WebMethod
    public Currency getCurrencyById(int id) {
        return currencyDao.findById(id);
    }

    @WebMethod
    public Currency findByCode(String code) {
        return currencyDao.findByCode(code);
    }

    @WebMethod
    public List<Currency> getAllCurrencies() {
        return currencyDao.findAll();
    }

    @WebMethod
    public Currency save(Currency currency) {
        return currencyDao.save(currency);
    }

    @WebMethod
    public Currency deleteById(int id) {
        return currencyDao.deleteById(id);
    }
}
