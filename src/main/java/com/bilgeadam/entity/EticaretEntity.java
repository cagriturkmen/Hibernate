package com.bilgeadam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "eticaret", indexes = { @Index(columnList = "id", name = "bilgeadam_index", unique = true) })
public class EticaretEntity implements Serializable {
	
	private static final long serialVersionUID = -6734914422562766373L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "fiyat")
	private double price;
	@Column(name = "ürün_adı")
	private String productName;
	@Column(name = "renk")
	private String color;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date tarih;
	
	public EticaretEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EticaretEntity(int id, double price, String productName, String color) {
		super();
		this.id = id;
		this.price = price;
		this.productName = productName;
		this.color = color;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public Date getTarih() {
		return tarih;
	}
	
	public void setTarih(Date tarih) {
		this.tarih = tarih;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "EticaretEntity [id=" + id + ", price=" + price + ", productName=" + productName + ", color=" + color
				+ ", tarih=" + tarih + "]";
	}
	
}
