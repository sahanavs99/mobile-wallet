package com.onlineRecharge.exception;

public class NoAccountFoundException extends Exception {
	
private String message="No match with accNumber and id";

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public NoAccountFoundException() {
	super();
	// TODO Auto-generated constructor stub
}

public NoAccountFoundException(String message) {
	super(message);
	
	// TODO Auto-generated constructor stub
}


}

