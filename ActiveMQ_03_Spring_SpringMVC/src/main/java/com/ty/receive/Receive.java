package com.ty.receive;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.ty.listener.ConsumerListener;

@Component
public class Receive {
	private final static Logger LOG = LogManager.getLogger(Receive.class);
	@Autowired
	JmsTemplate jmsTemplate;

	@Resource(name = "queueDestination")
	Destination queueDestination;

	@Autowired
	ConsumerListener consumerListener;

	public void ReceiveText() {
		Message message = jmsTemplate.receive(queueDestination);
	}
}
