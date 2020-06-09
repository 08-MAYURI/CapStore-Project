package com.capgemini.capstore.dao;

import java.util.List;

import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ReturnProductBean;

public interface MerchantDao {
	
	/*
	 * public boolean addProduct(ProductBean productBean) ;
	 * 
	 * public boolean deleteProduct(int productId) ;
	 * 
	 * public boolean updateProduct(ProductBean productBean) ;
	 * 
	 * public List<ProductBean> getAllProducts() ;
	 */
	public List<ReturnProductBean> getReturnProductList(int merchantId) ;
 	public MerchantPermanentBean viewProfile(String email) ;
}
