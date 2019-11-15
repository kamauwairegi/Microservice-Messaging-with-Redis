package com.spring.redisblog.subscriber;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.redisblog.models.EmailDetail;

@Service
public class EmailSubscriber implements MessageListener {
	private final Logger LOGGER = LoggerFactory.getLogger(EmailSubscriber.class);
	ObjectMapper mapper = new ObjectMapper();

	@Override
	public void onMessage(Message message, byte[] bytes) {
		try {
			EmailDetail details = mapper.readValue(message.getBody(), EmailDetail.class);

			JSONArray jsonArray = new JSONArray(details.getEmails());

			LOGGER.info("Send batch emails to all emails listed as: " + details.getEmails());
			for (int i = 0; i < jsonArray.length(); i++) {
				String email = jsonArray.getString(i);
				LOGGER.info("Send single email to user based on any other criterial : " + email);
				LOGGER.info("Poster ID: " + details.getUserId());
				LOGGER.info("Blog ID: " + details.getBlogId());
				LOGGER.info("Recepient: " + email);
			}

		} catch (JSONException | IOException e) {
			e.printStackTrace();
		}
	}

}
