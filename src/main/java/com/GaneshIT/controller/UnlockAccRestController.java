package com.GaneshIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.GaneshIT.binding.UnlockAccountForm;
import com.GaneshIT.service.UserServiceI;

@RestController
public class UnlockAccRestController {

	@Autowired
	private UserServiceI userServiceI;
	
	@PostMapping("/unlockAcc")
	public String unlockAcc(@RequestBody UnlockAccountForm unlockAccountForm) {
		boolean unlockAccount = userServiceI.unlockAccount(unlockAccountForm);
		
		if(unlockAccount) {
			return "Account Unlock";
		}
		return "Fail to Unlock Account";
		
		
	}
	
	
}
