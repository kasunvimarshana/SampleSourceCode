package com.kasun.SpringAnnotation_Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{

	@Autowired
	private Tyre tyre;

	public Tyre getTyre() {
		return tyre;
	}

	public void setTyre(Tyre tyre) {
		this.tyre = tyre;
	}
	
	public void drive() {
		// TODO Auto-generated method stub
		System.out.println("Bike...");
		System.out.println( tyre );
	}

}
