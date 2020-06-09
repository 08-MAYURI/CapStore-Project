package com.capgemini.capstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ReturnProductBean;
import com.capgemini.capstore.dao.MerchantDao;
import com.capgemini.capstore.validation.Validation;

public class MerchantServiceImpl implements MerchantService{

	@Autowired
	private MerchantDao merchantDao;
	@Autowired
	Validation Validation;

	@Override
	public List<ReturnProductBean> getReturnProductList(int merchantId) {
		return merchantDao.getReturnProductList(merchantId);
	}
	
	@Override
	public MerchantPermanentBean viewProfile(String email) {
		return merchantDao.viewProfile(email);
	}


}
