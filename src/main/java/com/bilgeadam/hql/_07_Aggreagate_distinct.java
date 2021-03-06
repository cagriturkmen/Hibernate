package com.bilgeadam.hql;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.utils.HibernateUtil;

public class _07_Aggreagate_distinct {
	
	private static final Logger logger = LogManager.getLogger(_07_Aggreagate_distinct.class);
	
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionfactory().openSession();
		String hql = "select distinct(bigData) from  StudentEntity as stu";
		TypedQuery<String> typedQuery = session.createQuery(hql, String.class);
		
		ArrayList<String> studentEntities = (ArrayList<String>) typedQuery.getResultList();
		for (String temp : studentEntities) {
			logger.info(temp);
		}
	}
}
