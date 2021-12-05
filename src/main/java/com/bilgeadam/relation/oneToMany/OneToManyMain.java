package com.bilgeadam.relation.oneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.bilgeadam.utils.HibernateUtil;

public class OneToManyMain {
	
	public static void main(String[] args) {
		
		// her zaman tek olanla başla
		// 1
		Teacher teacher = new Teacher("Mustafa Kemal", "Atatürk");
		teacher.setStudentList(new ArrayList<Student>());
		// N
		Student student = new Student("Çağrı", "Türkmen");
		student.setTeacher(teacher);
		teacher.getStudentList().add(student);
		Student student2 = new Student("Hamit", "Mızrak");
		student2.setTeacher(teacher);
		teacher.getStudentList().add(student2);
		
		// controller - crud
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		// create
		// session.getTransaction().begin();
		// session.persist(teacher);
		// session.getTransaction().commit();
		
		// find teacher
		Teacher findTeacher = session.find(Teacher.class, 1);
		System.out.println(findTeacher);
		// find student
		
		// hibernate innerJoin : stu.teacher.teacherId
		String hql = "select stu from Student as stu where stu.teacher.teacherId=1";
		TypedQuery<Student> studentList = session.createQuery(hql, Student.class);
		List<Student> list = studentList.getResultList();
		for (Student temp : list) {
			System.out.println(temp);
			
		}
	}
	
}
