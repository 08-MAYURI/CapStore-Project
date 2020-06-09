package com.capgemini.capstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.capstore.bean.CapstoreResponse;
import com.capgemini.capstore.bean.MerchantPermanentBean;
import com.capgemini.capstore.bean.ReturnProductBean;
import com.capgemini.capstore.service.MerchantService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class MerchantController {
	@Autowired
	MerchantService merchantService;
	String success = "success";
	
	@GetMapping("/viewProfile")
	public CapstoreResponse viewProfile(@RequestParam String email) {
		CapstoreResponse capstoreResponseBean = new CapstoreResponse();
		MerchantPermanentBean merchantPermanentBean = merchantService.viewProfile(email);
		capstoreResponseBean.setStatusCode(200);
		capstoreResponseBean.setMessage(success);
		capstoreResponseBean.setDescription(" Profile Found");
		capstoreResponseBean.getProductList();
		return capstoreResponseBean;

	}
	
	@GetMapping("/getReturnProductList")
	public CapstoreResponse getReturnProductList(@RequestParam int productId) {
		List<ReturnProductBean> productList = merchantService.getReturnProductList(productId);
		CapstoreResponse capstoreResponseBean = new CapstoreResponse();
		capstoreResponseBean.setStatusCode(200);
		capstoreResponseBean.setMessage(success);
		capstoreResponseBean.setDescription("Return Product List Found...");
		capstoreResponseBean.getProductList();
		return capstoreResponseBean;
	}

}
