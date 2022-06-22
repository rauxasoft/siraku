package com.sinensia.siraku.backend.auditoria.integration.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="REQUESTLOGS")
public class RequestLogPL implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@TableGenerator(name = "GENERADOR",
					table = "SECUENCIAS",
					pkColumnName = "NOMBRE",
					pkColumnValue = "REQUESTLOG_SEQ",
					valueColumnName = "VALOR",
					allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="GENERADOR")
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_HORA")
	private Date timeStamp;
	
	private String ip;
	private String url;
	private Long elapsedTime;
	private String method;
	private String httpStatusCode;
	
	public RequestLogPL() {
		
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
		RequestLogPL other = (RequestLogPL) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "RequestLogPL [id=" + id + ", timeStamp=" + timeStamp + ", ip=" + ip + ", url=" + url + ", elapsedTime="
				+ elapsedTime + ", method=" + method + ", httpStatusCode=" + httpStatusCode + "]";
	}

}
