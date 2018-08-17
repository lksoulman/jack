package com.jack.service.mq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MqProducerMain {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "classpath:spring/kafka-producer.xml" });
		
		Thread.currentThread().sleep(10000000);
	}
}
