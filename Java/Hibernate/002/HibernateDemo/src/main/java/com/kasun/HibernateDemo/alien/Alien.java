package com.kasun.HibernateDemo.alien;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Alien {
	
	@Id
	private int aid;
	private AlienName aname;
	private String color;
	@Transient
	private String temp_attr_1;
	@Transient
	private String temp_attr_2;
	@Transient
	private String temp_attr_3;
	
	public Alien() {}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public AlienName getAname() {
		return aname;
	}
	public void setAname(AlienName aname) {
		this.aname = aname;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}
}
