package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.hibernateconfig.IDataBaseCrud;

public class StudentController implements Serializable, IDataBaseCrud<StudentEntity> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3815337198977713489L;
	private static final Logger logger = LogManager.getLogger(StudentController.class); // logger classı import
	
	public static void main(String[] args) {
		logger.trace(args);
	}
	// DML: Create Delete Update : transaction(ya hep ya hiç)
	// DQL: select
	// create : persist
	// delete : remove
	
	// oluşturmak
	@Override
	public void create(StudentEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("Ekleme tamamdır." + StudentController.class);
			
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi" + StudentController.class);
			e.printStackTrace();
		}
		
	}
	
	// silmek
	@Override
	public void delete(StudentEntity entity) {
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme tamamdır." + StudentController.class);
			}
			
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi" + StudentController.class);
			e.printStackTrace();
		}
		
	}
	
	// güncellemek
	@Override
	public void update(StudentEntity entity) {
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			findEntity.setEmailAddress(entity.getEmailAddress());
			findEntity.setStudentName(entity.getStudentName());
			findEntity.setStudentPassword(entity.getStudentPassword());
			findEntity.setStudentSurname(entity.getStudentSurname());
			
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.merge(findEntity);
			session.getTransaction().commit();
			logger.info("Güncelleme başarılı." + StudentEntity.class);
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi" + StudentController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<StudentEntity> list() {
		
		Session session = databaseConnectionHibernate();
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from StudentEntity as str where str.id>:key";
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<StudentEntity> arrayList = (ArrayList<StudentEntity>) typedQuery.getResultList();
		return arrayList;
	}
	
	// find
	@Override
	public StudentEntity find(long id) {
		Session session = databaseConnectionHibernate();
		StudentEntity studentEntity;
		try {
			studentEntity = session.find(StudentEntity.class, id);
			if (studentEntity != null) {
				logger.info("bulundu..." + studentEntity);
			} else {
				logger.info("Aradığınız kriterde sonuçlar bulunamadı...");
				return null;
			}
		} catch (Exception e) {
			logger.error("arama anında hata meydana geldi" + StudentController.class);
			e.printStackTrace();
		}
		return null;
	}
	
	// tek kayıt döndermek
	@Override
	public StudentEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDataBaseCrud.super.singleResult(id);
	}
	
}
