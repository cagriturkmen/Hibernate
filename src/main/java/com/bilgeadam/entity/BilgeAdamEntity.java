package com.bilgeadam.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "bilge_adam")
public class BilgeAdamEntity implements Serializable {
	
	private static final long serialVersionUID = 2511708232079061708L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	// blob
	// clob
	@Lob
	private byte[] bigData;
	
	// email:
	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;
	
	// password
	@Column(name = "password", updatable = false)
	private String password;
	
	@Column(name = "specific_value", insertable = false)
	private String specificValue;
	
	@Column(name = "price", length = 10)
	private double price;
	
	// getters setters
	public long getId() {
		return id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSpecificValue() {
		return specificValue;
	}
	
	public void setSpecificValue(String specificValue) {
		this.specificValue = specificValue;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public byte[] getBigData() {
		return bigData;
	}
	
	public void setBigData(byte[] bigData) {
		this.bigData = bigData;
	}
	
	@Override
	public String toString() {
		return "BilgeAdamEntity [id=" + id + ", email=" + email + ", password=" + password + ", specificValue="
				+ specificValue + "]";
	}
	
	public BilgeAdamEntity(long id, String email, String password, String specificValue) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.specificValue = specificValue;
	}
	
	public BilgeAdamEntity() {
	}
	
}
