package com.spring.redisblog.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.redisblog.Publisher.Publisher;
import com.spring.redisblog.models.EmailDetail;

@RestController
public class BlogController {

	@Autowired
	Publisher publisher;

	@GetMapping("/simulate-post-blog")
	public void postBlog() {

		try {
			EmailDetail details = new EmailDetail();
			details.setBlogId("1");
			details.setUserId("1");
			List<String> list = new ArrayList<String>();
			list.add("devtest1@gmail.com");
			list.add("devtest2@gmail.com");
			list.add("devtest3@gmail.com");

			details.setEmails(list);
			publisher.publish(details);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}