package com.github.edgar615.spring.admin;

import de.codecentric.boot.admin.server.domain.entities.Instance;
import de.codecentric.boot.admin.server.domain.entities.InstanceRepository;
import de.codecentric.boot.admin.server.domain.events.InstanceEvent;
import de.codecentric.boot.admin.server.domain.events.InstanceStatusChangedEvent;
import de.codecentric.boot.admin.server.notify.AbstractStatusChangeNotifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Created by Edgar on 2018/7/11.
 *
 * @author Edgar  Date 2018/7/11
 */
public class CustomNotifier extends AbstractStatusChangeNotifier {

  public CustomNotifier(
          InstanceRepository repositpry) {
    super(repositpry);
  }

  @Override
  protected Mono<Void> doNotify(InstanceEvent event, Instance instance) {
    return Mono.fromRunnable(() -> {
      if (event instanceof InstanceStatusChangedEvent) {
        System.out.println(instance.getRegistration().getName());
        System.out.println(event.getInstance());
        System.out.println(((InstanceStatusChangedEvent) event).getStatusInfo().getStatus());
      } else {
        System.out.println(instance.getRegistration().getName());
        System.out.println(event.getInstance());
        System.out.println(event.getType());
      }
    });
  }
}
