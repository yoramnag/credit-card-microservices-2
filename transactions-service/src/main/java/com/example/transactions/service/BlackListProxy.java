package com.example.transactions.service;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.transactions.dto.BlackList;


//@FeignClient(name = "black-list" , url="localhost:8000/api")
@FeignClient(name = "black-list")
public interface BlackListProxy {
	
	@GetMapping("api/blacklistCard/{creditCardNumber}")
	public boolean findCreditCard(@PathVariable String creditCardNumber);
	
	@PostMapping("api/blacklist")
	public ResponseEntity<Object> createBlackListCard(@Valid @RequestBody BlackList blackList);

}
