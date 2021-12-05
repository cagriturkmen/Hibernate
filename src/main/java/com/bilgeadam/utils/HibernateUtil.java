package com.bilgeadam.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bilgeadam.entity.BilgeAdamEntity;
import com.bilgeadam.entity.EticaretEntity;
import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.enumx.PencilEntity;
import com.bilgeadam.relation.oneToMany.Student;
import com.bilgeadam.relation.oneToMany.Teacher;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();
	
	private static SessionFactory sessionFactoryHibernate() {
		try {
			Configuration configuration = new Configuration();
			// class ekle
			configuration.addAnnotatedClass(StudentEntity.class);
			configuration.addAnnotatedClass(BilgeAdamEntity.class);
			configuration.addAnnotatedClass(EticaretEntity.class);
			configuration.addAnnotatedClass(PencilEntity.class);
			
			configuration.addAnnotatedClass(Student.class);
			configuration.addAnnotatedClass(Teacher.class);
			SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return sessionFactory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
}
