package com.github.edgar615.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	@Autowired
	private SendService sendService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@ServiceActivator(inputChannel = Processor.INPUT + ".s3.errors") //channel name 'input.myGroup.errors'
	public void error(Message<?> message) {
		System.out.println("Handling ERROR: " + message);
	}

	@GetMapping("/")
	public String send() {
		sendService.sendMessage("haha");
		return "foo";
	}

}