package com.ptdataservice.model;

import java.util.Date;

public class PTData {

	int id;
	String name;
	String email;
	Date date;

	public PTData() {
		super();
	}

	public PTData(int id, String name, String email, Date date) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PTData [id=" + id + ", name=" + name + ", email=" + email + ", date=" + date + "]";
	}

}
