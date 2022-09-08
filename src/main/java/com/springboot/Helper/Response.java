package com.springboot.Helper;

import org.springframework.stereotype.Component;

@Component
public class Response {
	
	private String message;
	@Override
	public String toString() {
		return "Response [message=" + message + ", content=" + content + "]";
	}
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(String message, String content) {
		super();
		this.message = message;
		this.content = content;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	private String content;

}
