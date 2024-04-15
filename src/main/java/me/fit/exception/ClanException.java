package me.fit.exception;

public class ClanException extends Exception{
	
	private String message;

	public ClanException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
