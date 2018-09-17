package com.orderservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RefreshScope
public class OrderController {

	@Value("${user.discountFactor}")
	int discountFactor;
	
	int cnt = 0;
	
	@GetMapping(value = "/discount/{userName}")
	public ResponseEntity<String> checkForDistcount() {
		cnt ++;
		String result = null;
		if(cnt % discountFactor == 0) {
			result = "Discount is applied"; 
		}else {
			result = "Discount is not Applied";
		}
		System.out.println("This is request number " + cnt);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
