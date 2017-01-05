package com.daelly.project.onlinejudge.expection;

public class AuthException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7627543227120310008L;
	
	public AuthException(){}
	
	public AuthException(String message) {
		super(message);
	}
	
}
