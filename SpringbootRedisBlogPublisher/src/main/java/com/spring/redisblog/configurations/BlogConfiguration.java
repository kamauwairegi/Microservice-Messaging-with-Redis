package com.spring.redisblog.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

import com.spring.redisblog.Publisher.Publisher;

@Configuration
public class BlogConfiguration {
	
	@Value("${redis.topic.name:chat}")
	private String topicName;
	
	@Autowired
	RedisTemplate<?, ?> redisTemplate;

	@Bean
	Publisher redisPublisher() {
		return new Publisher(redisTemplate, topic());
	}

	@Bean
	ChannelTopic topic() {
		return new ChannelTopic(topicName);
	}
}
