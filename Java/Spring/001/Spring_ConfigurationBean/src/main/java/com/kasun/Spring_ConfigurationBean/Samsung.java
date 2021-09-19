package com.kasun.Spring_ConfigurationBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung {

	@Autowired
	@Qualifier("mediaTek")
	MobileProcessor mobileProcessor;

	public MobileProcessor getMobileProcessor() {
		return mobileProcessor;
	}

	public void setMobileProcessor(MobileProcessor mobileProcessor) {
		this.mobileProcessor = mobileProcessor;
	}
	
	public void config() {
		System.out.println("Samsung ...");
		mobileProcessor.process();
	}
	
}
