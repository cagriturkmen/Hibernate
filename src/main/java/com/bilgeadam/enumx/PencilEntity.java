package com.bilgeadam.enumx;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pencil")
public class PencilEntity implements Serializable {
	
	private static final long serialVersionUID = -5575357616086463051L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String pencilName;
	@Enumerated(value = EnumType.STRING)
	private EPencil pencilType;
	private String pencilBrand;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPencilName() {
		return pencilName;
	}
	
	public void setPencilName(String pencilName) {
		this.pencilName = pencilName;
	}
	
	public EPencil getPencilType() {
		return pencilType;
	}
	
	public void setPencilType(EPencil pencilType) {
		this.pencilType = pencilType;
	}
	
	public String getPencilBrand() {
		return pencilBrand;
	}
	
	public void setPencilBrand(String pencilBrand) {
		this.pencilBrand = pencilBrand;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
