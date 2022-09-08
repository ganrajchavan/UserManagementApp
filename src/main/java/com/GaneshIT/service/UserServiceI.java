package com.GaneshIT.service;

import java.util.Map;

import com.GaneshIT.binding.LoginForm;
import com.GaneshIT.binding.UserForm;

public interface UserServiceI {

	public String loginCheck(LoginForm loginForm);
	
	public Map<Integer,String>  getCountries();

	public Map<Integer,String> getStates(Integer countryId);

	public Map<Integer,String> getCities(Integer stateId);

	public boolean  saveUser(UserForm userForm);

}
