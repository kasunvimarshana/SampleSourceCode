package jcg.ssowmya.demo.soapwebservices;

import javax.xml.ws.Endpoint;

public class CurrencyServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/currencyservice", new CurrencyServiceImpl());
    }
}
