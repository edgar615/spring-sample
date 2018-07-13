package com.github.edgar615.spring.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.notify.CompositeNotifier;
import de.codecentric.boot.admin.server.notify.LoggingNotifier;
import de.codecentric.boot.admin.server.notify.Notifier;
import de.codecentric.boot.admin.server.notify.RemindingNotifier;
import de.codecentric.boot.admin.server.notify.filter.FilteringNotifier;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
//@EnableDiscoveryClient
public class SpringBootAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAdminApplication.class, args);
    }

    @Bean
    public LoggingNotifier loggerNotifier(InstanceRepository repository) {
        return new LoggingNotifier(repository);
    }

    @Bean
    public CustomNotifier customNotifier(InstanceRepository repository) {
        return new CustomNotifier(repository);
    }

    // tag::configuration-filtering-notifier[]
    @Configuration
    public static class NotifierConfig {
        private final InstanceRepository repository;
        private final ObjectProvider<List<Notifier>> otherNotifiers;

        public NotifierConfig(InstanceRepository repository, ObjectProvider<List<Notifier>> otherNotifiers) {
            this.repository = repository;
            this.otherNotifiers = otherNotifiers;
        }

        @Bean
        public FilteringNotifier filteringNotifier() { // <1>
            CompositeNotifier delegate = new CompositeNotifier(otherNotifiers.getIfAvailable(Collections::emptyList));
            return new FilteringNotifier(delegate, repository);
        }

        @Primary
        @Bean(initMethod = "start", destroyMethod = "stop")
        public RemindingNotifier remindingNotifier() { // <2>
            RemindingNotifier notifier = new RemindingNotifier(filteringNotifier(), repository);
            notifier.setReminderPeriod(Duration.ofMinutes(10));
            notifier.setCheckReminderInverval(Duration.ofSeconds(10));
            return notifier;
        }
    }
}