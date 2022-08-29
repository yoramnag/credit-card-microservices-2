package com.example.blackList.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.example.blackList.dao.BlackListRepository;
import com.example.blackList.entity.BlackList;
import com.example.blackList.exception.BlackListCardNotFoundException;
import com.example.blackList.exception.LuhnException;

@Service
public class BlackListService {
	
	@Autowired
	private BlackListRepository blackListRepository;
	
	@Autowired
	private Environment environment;
	
	// Return all BlackList
	public List<BlackList> findAll(){
		return blackListRepository.findAll();
	}
	
	//Return BlackList card by his ID
	public Optional<BlackList> findById(int id) {
		Optional<BlackList> blackList = blackListRepository.findById(id);
		
		if(!blackList.isPresent()) {
			throw new BlackListCardNotFoundException("id - " + id);
		}
		String port = environment.getProperty("local.server.port");
		blackList.get().setEnvironment(port);
		return blackList;
	}
	
	// Save new credit card to the black list 
	public BlackList saveBlackListRepository (BlackList blackList) {
		// Validate credit card with luhn algorithm 
		if (!Utils.luhnValidetor(blackList.getCreditCard())) {
			throw new LuhnException(Utils.mask(blackList.getCreditCard()) + " is not valid");
		}
		blackList.setMaskCreditCard(Utils.mask(blackList.getCreditCard()));
		blackList.setCreditCard(Utils.maskCreditCard(blackList.getCreditCard()));
		return blackListRepository.save(blackList);
	}
	
	// Check if credit card exist in blacklist
	public boolean isBlaclListCardExist(int id) {
		Optional<BlackList> BlackListCard = blackListRepository.findById(id);
		
		if(!BlackListCard.isPresent()) {
			throw new BlackListCardNotFoundException("id - " + id);
		}
		return true;
	}
	
	// Delete BlackList card
	public void deleteBlaclListCard(int id) {
		blackListRepository.deleteById(id);
	}
	
	// Check if credit card number exist in blacklist
	public boolean findBlackListCard(String creditCardNumber){
		creditCardNumber = Utils.maskCreditCard(creditCardNumber);
		Optional<BlackList> blackList = blackListRepository.findByCreditCard(creditCardNumber);
		if(!blackList.isPresent()) {
			return false;
		}
		return true;
	}
	

}
