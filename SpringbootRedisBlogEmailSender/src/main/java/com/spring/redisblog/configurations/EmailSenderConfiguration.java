package com.spring.redisblog.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import com.spring.redisblog.subscriber.EmailSubscriber;

@Configuration
public class EmailSenderConfiguration {
	@Value("${redis.topic.name:chat}")
	String topicName;

	@Autowired
	RedisConnectionFactory redisConnectionFactory;

	@Bean
	RedisMessageListenerContainer container() {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		container.addMessageListener(messageListener(), topic());
		container.setConnectionFactory(redisConnectionFactory);
		return container;
	}

	@Bean
	MessageListenerAdapter messageListener() {
		return new MessageListenerAdapter(new EmailSubscriber());
	}

	@Bean
	ChannelTopic topic() {
		return new ChannelTopic(topicName);
	}
}
