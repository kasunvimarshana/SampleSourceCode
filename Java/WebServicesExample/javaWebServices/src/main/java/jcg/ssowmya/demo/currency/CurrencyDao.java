package jcg.ssowmya.demo.currency;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CurrencyDao {
    private static List<Currency> currencyList = new ArrayList<Currency>();
    private static int currencyCount = 0;
    static {
        currencyList.add(new Currency(1,"Indian Rupee","Rs","INR"));
        currencyList.add(new Currency(2,"American Dollar","$","USD"));
        currencyList.add(new Currency(3,"Canadian Dollar","$","CAD"));
        currencyList.add(new Currency(4, "Australian Dollar","$","AUD"));
    }
    public Currency findByCode(String code) {
        Optional<Currency> currencyOptional = currencyList.stream().filter(matchId->code.equals(matchId.getCode())).findAny();
        if(currencyOptional.isPresent())
            return currencyOptional.get();
        return null;
    }
    public Currency findById(int id) {
        Optional<Currency> currencyOptional = currencyList.stream().filter(matchId->matchId.getId()==id).findAny();
        if(currencyOptional.isPresent())
            return currencyOptional.get();
        return null;
    }
    public List<Currency> findAll() {
        return currencyList;
    }

    public Currency save(Currency currency) {
        if(currency.getId() == null)
            currency.setId(++currencyCount);
        currencyList.add(currency);
        return currency;
    }
    public Currency deleteById(int id) {
        Optional<Currency> currencyOptional = currencyList.stream().filter(matchId->matchId.getId()==id).findAny();
        if(currencyOptional.isPresent()) {
            Currency removeCurrency = currencyOptional.get();
            currencyList.remove(removeCurrency);
            return removeCurrency;
        }
        return null;
    }

}
