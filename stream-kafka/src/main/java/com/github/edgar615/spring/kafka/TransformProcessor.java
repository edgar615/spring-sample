//package com.github.edgar615.spring.kafka;
//
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Processor;
//import org.springframework.messaging.handler.annotation.SendTo;
//
//@EnableBinding(Processor.class)
//public class TransformProcessor {
//
//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public String handle(String value) {
//		System.out.println("Received: " + value);
//		return value.toUpperCase();
//	}
//}