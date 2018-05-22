package com.ty.metting.manager;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQManager {
	private final static Logger LOG = LogManager.getLogger(ActiveMQManager.class);
	@Autowired
	JmsTemplate jmsTemplate;

	@Resource(name = "queueDestination")
	Destination queueDestination;
	
	

	public void send(String text) {
		jmsTemplate.setDefaultDestination(queueDestination);
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage("我就是发送的消息" + text);
			}
		});
	}
}
