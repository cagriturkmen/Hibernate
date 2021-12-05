package com.bilgeadam.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.utils.HibernateUtil;

public class _HqlQuery1 {
	private static final Logger logger = LogManager.getLogger(_HqlQuery1.class);
	
	public static void main(String[] args) {
		// interface uğramayacaksam mutlaka yapmalıyız
		// HibernateUtil.getSessionfactory().openSession()
		// transaction yapmamıza gerek yok çünkü select yapıyoruz yani sadece okuma
		Session session = HibernateUtil.getSessionfactory().openSession();
		String hql = "select stu from StudentEntity as stu";
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		
		ArrayList<StudentEntity> studentEntities = (ArrayList<StudentEntity>) typedQuery.getResultList();
		
		for (StudentEntity temp : studentEntities) {
			logger.info(temp);
		}
	}
}
