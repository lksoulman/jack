package com.jack.service.mq.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.listener.MessageListener;

public class MessageConsumerListerner implements MessageListener<String, String> {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageConsumerListerner.class);
	
	@Override
	public void onMessage(ConsumerRecord<String, String> data) {
		logger.info("kafka message : " + data);
		System.out.println("kafka message : " + data);
	}
}
