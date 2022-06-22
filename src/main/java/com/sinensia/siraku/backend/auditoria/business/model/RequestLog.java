package com.sinensia.siraku.backend.auditoria.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class RequestLog implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Date timeStamp;
	private String ip;
	private String url;
	private Long elapsedTime;
	private String method;
	private String httpStatusCode; 
	
	public RequestLog() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(Long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RequestLog other = (RequestLog) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "RequestLog [id=" + id + ", timeStamp=" + timeStamp + ", ip=" + ip + ", url=" + url + ", elapsedTime="
				+ elapsedTime + ", method=" + method + ", httpStatusCode=" + httpStatusCode + "]";
	}
	
}
