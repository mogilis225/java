package com.oauth2.app.model;

import java.io.Serializable;

public class Hello implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String message;

	public Hello() {

	}	

	public Hello(Integer id, String message) {
		super();
		this.id = id;
		this.message = message;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Hello [id=" + id + ", message=" + message + "]";
	}
	
	

}
