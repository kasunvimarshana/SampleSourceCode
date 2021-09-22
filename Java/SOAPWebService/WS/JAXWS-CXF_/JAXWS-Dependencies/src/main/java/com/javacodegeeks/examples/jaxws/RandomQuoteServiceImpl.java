package com.javacodegeeks.examples.jaxws;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.jws.WebService;

@WebService(endpointInterface = "com.javacodegeeks.examples.jaxws.RandomQuoteService")
public class RandomQuoteServiceImpl implements RandomQuoteService {
	
	private static List<String> quoteList;
	
	static {
		quoteList = new ArrayList<String>();
		quoteList.add("You cannot escape the responsibility of tomorrow by evading it today");
		quoteList.add("I think therefore I am");
		quoteList.add("It was the best of times, it was the worst of times...");
	}

	@Override
	public String getQuote() {
		Random random = new Random();
		int index = random.nextInt(quoteList.size());
		return (String) quoteList.get(index);
	}
}
