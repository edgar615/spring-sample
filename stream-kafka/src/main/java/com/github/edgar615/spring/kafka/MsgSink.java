package com.github.edgar615.spring.kafka;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class MsgSink {
 
    @StreamListener(Sink.INPUT)
    public void messageSink(Object payload) {
        System.out.println("Received: " + payload);
    }

//    @StreamListener(target = Sink.INPUT, condition = "headers['type']=='bogey'")
//    public void receiveBogey(@Payload BogeyPojo bogeyPojo) {
//        // handle the message
//    }
//
//    @StreamListener(target = Sink.INPUT, condition = "headers['type']=='bacall'")
//    public void receiveBacall(@Payload BacallPojo bacallPojo) {
//        // handle the message
//    }

//    @StreamListener(target = Sink.INPUT, condition = "payload.class.simpleName=='Dog'")
//    public void bark(Dog dog) {
//        // handle the message
//    }
//
//    @StreamListener(target = Sink.INPUT, condition = "payload.class.simpleName=='Cat'")
//    public void purr(Cat cat) {
//        // handle the message
//    }
}