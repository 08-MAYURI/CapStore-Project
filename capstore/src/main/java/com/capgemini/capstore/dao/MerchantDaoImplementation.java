package com.capgemini.capstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ReturnProductBean;
import com.capgemini.capstore.exception.MerchantException;

public class MerchantDaoImplementation implements MerchantDao{

	@PersistenceUnit
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<ReturnProductBean> getReturnProductList(int merchantId) {
		
		List<ReturnProductBean> productList = null;
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			String jpql = "from ReturnProductBean where merchantId =:merchantId ";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("merchantId", merchantId);
			productList = (List<ReturnProductBean>) query.getResultList();
			if (productList == null || productList.isEmpty()) {
				throw new MerchantException("Return Product List folder is empty");
			}
		} catch (Exception e) {
			throw new MerchantException("Return Product List folder is empty");
		}
		return productList;
	}

	@Override
	public MerchantPermanentBean viewProfile(String email) {
	MerchantPermanentBean merchantPermanentBean = null;
		try {

			EntityManager entityManager = entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction = entityManager.getTransaction();
			String jpql = "from MerchantPermanentBean where email=:email";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("email", email);
			merchantPermanentBean = (MerchantPermanentBean) query.getSingleResult();
			return merchantPermanentBean;
		} catch (Exception e) {
			throw new MerchantException(" Email not Present");
		}
	}
	

}
//
//EntityManager entityManager = entityManagerFactory.createEntityManager();
//EntityTransaction entityTransaction = entityManager.getTransaction();
//String jpql = "from ReturnProductBean";
//Query query = entityManager.createQuery(jpql);
//List<ReturnProductBean> productList = null;
//try {
//	entityTransaction.begin();
//    productList = query.getResultList();
//	entityTransaction.commit();
//
//	if (productList == null || productList.isEmpty()) {
//		throw new MerchantException("there are no products returned !!");
//	}
//
//} catch (Exception e) {
//	throw new MerchantException("there are no products returned !!");
//}
//
//return productList;