package com.faceye.test.component.cache.service;

import java.io.Serializable;
import java.util.Date;

public class SetObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6434046333436049074L;
	
	
	private long id;
	private String name;
	private Date date=new Date();
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

}
