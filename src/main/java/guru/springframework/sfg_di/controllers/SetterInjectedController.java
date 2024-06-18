package guru.springframework.sfg_di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.sfg_di.services.GreetingService;

@Controller
public class SetterInjectedController {
  private GreetingService greetingService;

  @Autowired
  @Qualifier("setterInjectedGreetingServiceImpl")
  public void setGreetingService(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  public String getGreeting() {
    return greetingService.sayGreeting();
  }
}
