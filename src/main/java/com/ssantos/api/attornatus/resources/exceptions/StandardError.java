package com.ssantos.api.attornatus.resources.exceptions;

public class StandardError {

	private Integer status;
	private Long timestemp;
	private String message;

	public StandardError() {
		super();
	}

	public StandardError(Integer status, Long timestemp, String message) {
		super();
		this.status = status;
		this.timestemp = timestemp;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getTimestemp() {
		return timestemp;
	}

	public void setTimestemp(Long timestemp) {
		this.timestemp = timestemp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
