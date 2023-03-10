package com.mycompany.test.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class TopicCreator {

	private final KafkaAdmin kafkaAdmin;

	public TopicCreator(KafkaAdmin kafkaAdmin) {
		this.kafkaAdmin = kafkaAdmin;
	}

	public void createTopicWithGroupId(String topicName, int partitions, short replicationFactor, String groupId) {
		AdminClient adminClient = AdminClient.create(kafkaAdmin.getConfigurationProperties());
		NewTopic newTopic = new NewTopic(topicName, partitions, replicationFactor);
		newTopic.configs(Collections.singletonMap("retention.ms", "3600000"));
		adminClient.createTopics(Collections.singleton(newTopic));
		adminClient.close();
	}

}
