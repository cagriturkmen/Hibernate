package com.bilgeadam.hql;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.utils.HibernateUtil;

public class _02_Aggreagate_Count {
	// logger
	private static final Logger logger = LogManager.getLogger(_02_Aggreagate_Count.class);
	
	public static void main(String[] args) {
		// Session
		Session session = HibernateUtil.getSessionfactory().openSession();
		String hql = "select count(bigData) from StudentEntity";
		
		TypedQuery<Long> typedQuery = session.createQuery(hql, Long.class);
		Long bigDataCounter = typedQuery.getSingleResult();
		logger.info(" " + bigDataCounter);
		// kodlar
	}
	
}
