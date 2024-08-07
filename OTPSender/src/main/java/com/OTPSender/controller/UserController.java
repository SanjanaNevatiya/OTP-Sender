package com.OTPSender.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.OTPSender.services.OTPService;
import com.OTPSender.services.userService;

@Controller
public class UserController {
	public static String Otp1;
	@Autowired
	private userService userservice;
	@Autowired
	private OTPService otpservice;
	
	@GetMapping("/adminlogin")
	public String getlogin(Model model) {
		
		return "adminlogin";
	}
	
	@GetMapping("/loginsts")
	public String getOtp(@RequestParam ("username") String Username) {
		String demo="+91"+Username;
		String Otp=userservice.generateOtp(Username);
	    Otp1=Otp;
	    otpservice.sendOtp(demo,Otp);
	    System.out.println(Otp);
		return "success";
	}
	
	@GetMapping("/verify")
	public String verifyOtp(@RequestParam ("otp") String otp) {
		
		if(otp.equals(Otp1)) {
			return "verified";
		}
		else {
			return "error";
		}
		
	}

}
