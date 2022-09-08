package com.GaneshIT.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GaneshIT.binding.LoginForm;
import com.GaneshIT.binding.UserForm;
import com.GaneshIT.model.CityMasterEntity;
import com.GaneshIT.model.CountryMasterEntity;
import com.GaneshIT.model.StateMasterEntity;
import com.GaneshIT.model.UserAccountEntity;
import com.GaneshIT.repositories.CityRepo;
import com.GaneshIT.repositories.CountryRepo;
import com.GaneshIT.repositories.StateRepo;
import com.GaneshIT.repositories.UserAccountRepository;

@Service
public class UserServiceImpl implements UserServiceI{

	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private CountryRepo countryRepo;
	
	@Autowired
	private StateRepo stateRepo;

	@Autowired
	private CityRepo cityRepo;
	
	@Override
	public String loginCheck(LoginForm loginForm) {
		
		UserAccountEntity userAccountEntity = userAccountRepository.findByEmailAndPassword(loginForm.getEmail(),
				loginForm.getPassword());

		if (userAccountEntity != null) {
			String accStatus = userAccountEntity.getAccStatus();
			if (accStatus.equals("LOCKED")) {
				return "Your Account is locked";
			} else {
				return "Login successful. Welcome to Bikkad IT";
			}

		} else {
			return "Creditional Are invalid";
		}
		}

	@Override
	public Map<Integer, String> getCountries() {

		List<CountryMasterEntity> findAll = countryRepo.findAll();
		Map<Integer, String> countryMap = new HashMap<Integer, String>();
		for (CountryMasterEntity u : findAll) {
			countryMap.put(u.getCountryId(), u.getCountryName());
		}

		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		
		List<StateMasterEntity> states = stateRepo.findByCountryId(countryId);

		Map<Integer, String> statemap = new HashMap<Integer, String>();
		for (StateMasterEntity u : states) {
			statemap.put(u.getStateId(), u.getStateName());
		}
		return statemap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		
		List<CityMasterEntity> findByStateId = cityRepo.findByStateId(stateId);

		Map<Integer, String> cityMap = new HashMap<Integer, String>();

		for (CityMasterEntity u : findByStateId) {
			cityMap.put(u.getCityId(), u.getCityname());
		}

		return cityMap;
		
	}

	@Override
	public boolean saveUser(UserForm userForm) {
		
		userForm.setAccStatus("LOCKED");
		userForm.setPassword(generateRandomPassword());
		UserAccountEntity userAccountEntity = new UserAccountEntity();
		BeanUtils.copyProperties(userForm, userAccountEntity);

		UserAccountEntity save = userAccountRepository.save(userAccountEntity);

		if (save != null) {
			// send mail
			return true;
		}
		return false;
	}

	private String generateRandomPassword() {

		String randomPassword = RandomStringUtils.randomAlphanumeric(6);

		return randomPassword;

	}
	
	
	}

	

	
	
	


