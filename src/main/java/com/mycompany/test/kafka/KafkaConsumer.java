package com.mycompany.test.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class KafkaConsumer {

	@KafkaListener(topics = "my-topic", groupId = "my-group-app")
	public void receiveMessage(String message) {
		log.info("Received message in app: {}", message);
	}

}
