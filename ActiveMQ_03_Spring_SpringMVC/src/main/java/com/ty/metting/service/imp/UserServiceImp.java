package com.ty.metting.service.imp;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ty.metting.manager.ActiveMQManager;
import com.ty.metting.service.UserService;

@Service
@Transactional
public class UserServiceImp implements UserService {
	private final static Logger LOG = LogManager.getLogger(UserServiceImp.class);
	@Autowired
	private ActiveMQManager activeMQManager;

	@Override
	public void send(String text) {
		activeMQManager.send(text);
	}
}
