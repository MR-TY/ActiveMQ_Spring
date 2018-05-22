package com.ty.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ConsumerListener implements MessageListener {
	private final static Logger LOG = LogManager.getLogger(ConsumerListener.class);

	@Override
	public void onMessage(Message message) {
		TextMessage message2 = (TextMessage) message;
		try {
			System.out.println("与spring整合发出的消息：" + message2.getText());
		} catch (JMSException e) {
			System.out.println("发送的消息错误");
		}
	}
}
