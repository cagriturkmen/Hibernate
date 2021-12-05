package com.bilgeadam.relation.oneToMany;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_relation")
public class Student implements Serializable {
	
	private static final long serialVersionUID = -2164415709662861044L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	private String stuName;
	private String stuSurname;
	
	// composition
	@ManyToOne
	@JoinColumn(name = "teacherId")
	private Teacher teacher;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int studentId, String stuName, String stuSurname) {
		this.studentId = studentId;
		this.stuName = stuName;
		this.stuSurname = stuSurname;
	}
	
	public Student(String stuName, String stuSurname) {
		this.stuName = stuName;
		this.stuSurname = stuSurname;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public String getStuName() {
		return stuName;
	}
	
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	public String getStuSurname() {
		return stuSurname;
	}
	
	public void setStuSurname(String stuSurname) {
		this.stuSurname = stuSurname;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(stuName, stuSurname, studentId);
	}
	
	public Teacher getTeacher() {
		return teacher;
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(stuName, other.stuName) && Objects.equals(stuSurname, other.stuSurname)
				&& studentId == other.studentId;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", stuName=" + stuName + ", stuSurname=" + stuSurname + ", teacher="
				+ teacher + "]";
	}
	
}
