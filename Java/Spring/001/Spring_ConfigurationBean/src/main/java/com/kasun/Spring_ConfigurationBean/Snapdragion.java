package com.kasun.Spring_ConfigurationBean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Snapdragion implements MobileProcessor {

	public void process() {
		// TODO Auto-generated method stub
		System.out.println("Snapdragion...");
	}

}
