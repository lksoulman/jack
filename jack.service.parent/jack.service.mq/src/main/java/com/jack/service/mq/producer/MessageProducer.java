package com.jack.service.mq.producer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * 
 * @author chengyz
 *
 */

@Service
public class MessageProducer implements InitializingBean, DisposableBean {

	private static Logger logger = LoggerFactory.getLogger(MessageProducer.class);

	private static final int MAX_COUNT = 1000;

	private static volatile int conut = 1;

	private ExecutorService executorService;

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	private void doStart() {
		executorService = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(100000), new ThreadPoolExecutor.DiscardPolicy());

		FutureTask<Integer> task = (FutureTask<Integer>) executorService.submit(new Callable<Integer>() {
			private Integer integer = 1;

			@Override
			public Integer call() throws Exception {

				do {
					// kafkaTemplate.sendDefault("send message " + i + "数据");
					kafkaTemplate.sendDefault("Hello，Kafka");
					System.out.println("Hello，Kafka");
					// Thread.currentThread().sleep(100);
					incCount();
				} while (conut <= MAX_COUNT);

				return integer;
			}
		});

		// try {
		// Integer value = task.get();
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } catch (ExecutionException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// } finally {
		// executorService.shutdown();
		// }
	}

	private synchronized void incCount() {
		conut++;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		doStart();
	}

	@Override
	public void destroy() throws Exception {

		executorService.shutdown();
	}
}
