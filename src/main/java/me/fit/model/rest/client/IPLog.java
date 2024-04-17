package me.fit.model.rest.client;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = IPLog.GET_ALL, query = "Select ip from IPLog ip")
})
public class IPLog {
	
	public static final String GET_ALL = "IPLog.getAll";
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "iplog_seq")
	@JsonIgnore
	private Long id;
	
	private String ipString = "109.228.113.35";
	private String iptype = "IPv4";
	private String clientIp;
	private Date createdDate;
	
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getIpString() {
		return ipString;
	}
	
	public void setIpString(String ipString) {
		this.ipString = ipString;
	}
	
	public String getIptype() {
		return iptype;
	}
	public void setIptype(String iptype) {
		this.iptype = iptype;
	}
	
	public String getClientIp() {
		return clientIp;
	}
	
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	@Override
	public String toString() {
		return "IPLog [id=" + id + ", ipString=" + ipString + ", iptype=" + iptype + ", clientIp=" + clientIp
				+ ", createdDate=" + createdDate + "]";
	}

	
	
	
	
	
	
	

}
