//package com.github.edgar615.spring.admin;
//
//import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
//import de.codecentric.boot.admin.server.notify.Notifier;
//import de.codecentric.boot.admin.server.notify.RemindingNotifier;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//
//import java.time.Duration;
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//@EnableScheduling
//public class NotifierConfiguration {
//
//    @Autowired
//    private Notifier notifier;
//
//    @Autowired
//    private  InstanceRepository repository;
//
//    @Primary
//    @Bean(initMethod = "start", destroyMethod = "stop")
//    public RemindingNotifier remindingNotifier() {
//        RemindingNotifier notifier = new RemindingNotifier(notifier, repository);
//        notifier.setReminderPeriod(Duration.ofMinutes(1));
//        notifier.setCheckReminderInverval(Duration.ofSeconds(10));
//        return notifier;
//    }
//}