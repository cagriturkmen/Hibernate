package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.BilgeAdamEntity;
import com.bilgeadam.hibernateconfig.IDataBaseCrud;

public class BilgeAdamController implements Serializable, IDataBaseCrud<BilgeAdamEntity> {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LogManager.getLogger(BilgeAdamController.class); // logger classı import
	
	public static void main(String[] args) {
		logger.trace(args);
	}
	// DML: Create Delete Update : transaction(ya hep ya hiç)
	// DQL: select
	// create : persist
	// delete : remove
	
	@Override
	public void create(BilgeAdamEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamlandı" + BilgeAdamController.class);
		} catch (Exception e) {
			logger.warn("Ekleme sırasında hata oluştu" + BilgeAdamController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(BilgeAdamEntity entity) {
		try {
			BilgeAdamEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("silme tamamlandı" + BilgeAdamController.class);
			}
		} catch (Exception e) {
			logger.warn("Silme sırasında hata oluştu" + BilgeAdamController.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(BilgeAdamEntity entity) {
		try {
			BilgeAdamEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setEmail(entity.getEmail());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + BilgeAdamEntity.class);
			}
			
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<BilgeAdamEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from BilgeAdamEntity as str where str.id>=:key";
		TypedQuery<BilgeAdamEntity> typedQuery = session.createQuery(hql, BilgeAdamEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<BilgeAdamEntity> arrayList = (ArrayList<BilgeAdamEntity>) typedQuery.getResultList();
		logger.info("listelendi " + BilgeAdamEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public BilgeAdamEntity find(long id) {
		Session session = databaseConnectionHibernate();
		BilgeAdamEntity bilgeAdamEntity;
		try {
			bilgeAdamEntity = session.find(BilgeAdamEntity.class, id);
			
			if (bilgeAdamEntity != null) {
				System.out.println("bulundu... " + bilgeAdamEntity);
				return bilgeAdamEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + BilgeAdamController.class);
			e.printStackTrace();
		}
		return null;
	}
	
	// tek kayıt donder
	@Override
	public BilgeAdamEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDataBaseCrud.super.singleResult(id);
	}
	
}
