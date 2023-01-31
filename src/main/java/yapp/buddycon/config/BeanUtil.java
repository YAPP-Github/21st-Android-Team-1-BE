package yapp.buddycon.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeanUtil {

  private final ApplicationContext applicationContext;

  public Object getBean(String name) {
    return applicationContext.getBean(name);
  }

}
