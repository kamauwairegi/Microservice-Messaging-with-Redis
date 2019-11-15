package com.spring.redisblog.Publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.redisblog.models.EmailDetail;

public class Publisher {
	private static final Logger LOGGER = LoggerFactory.getLogger(Publisher.class);

	RedisTemplate<?, ?> redisTemplate;
	ChannelTopic topic;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Publisher(RedisTemplate<?, ?> redisTemplate, ChannelTopic topic) {
		this.redisTemplate = redisTemplate;
		this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer(EmailDetail.class));
		this.topic = topic;
	}

	public void publish(EmailDetail details) throws JsonProcessingException {
		LOGGER.info("Sending: {}", details);
		redisTemplate.convertAndSend(topic.getTopic(), details);
	}
}
