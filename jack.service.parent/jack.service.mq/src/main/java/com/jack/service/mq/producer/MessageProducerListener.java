package com.jack.service.mq.producer;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.support.ProducerListener;

public class MessageProducerListener implements ProducerListener<String, String> {

	@Override
	public void onSuccess(String topic, Integer partition, String key, String value, RecordMetadata recordMetadata) {
		System.out.println("==========kafka发送数据成功（日志开始）==========");
		System.out.println("----------topic:"+topic);
		System.out.println("----------partition:"+partition);
		System.out.println("----------key:"+key);
		System.out.println("----------value:"+value);
		System.out.println("----------RecordMetadata:"+recordMetadata);
		System.out.println("~~~~~~~~~~kafka发送数据成功（日志结束）~~~~~~~~~~");
	}

	@Override
	public void onError(String topic, Integer partition, String key, String value, Exception exception) {
		System.out.println("==========kafka发送数据错误（日志开始）==========");
		System.out.println("----------topic:"+topic);
		System.out.println("----------partition:"+partition);
		System.out.println("----------key:"+key);
		System.out.println("----------value:"+value);
		System.out.println("----------Exception:"+exception);
		System.out.println("~~~~~~~~~~kafka发送数据错误（日志结束）~~~~~~~~~~");
	}

	@Override
	public boolean isInterestedInSuccess() {
		System.out.println("监听启动");
		return false;
	}

	
}
