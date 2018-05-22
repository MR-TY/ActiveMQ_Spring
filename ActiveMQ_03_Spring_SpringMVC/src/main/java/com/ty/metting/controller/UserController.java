package com.ty.metting.controller;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ty.metting.service.UserService;

@Controller
public class UserController {
	private final static Logger LOG = LogManager.getLogger(UserController.class);
	@Autowired
	private UserService userService;

	@RequestMapping("/send")
	public String sendData() {
		for (int i = 0; i < 100; i++) {
			userService.send("消息已经发送");
		}
		return "/index.jsp";
	}
}
