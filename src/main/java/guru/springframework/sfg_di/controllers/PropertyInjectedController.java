package guru.springframework.sfg_di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.sfg_di.services.GreetingService;

@Controller
public class PropertyInjectedController {
  @Autowired
  @Qualifier("propertyInjectedGreetingServiceImpl")
  public GreetingService greetingService;

  public String getGreeting() {
    return greetingService.sayGreeting();
  }
}
