package guru.springframework.sfg_di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.sfg_di.controllers.ConstructorInjectedController;
import guru.springframework.sfg_di.controllers.I18nController;
import guru.springframework.sfg_di.controllers.MyController;
import guru.springframework.sfg_di.controllers.PropertyInjectedController;
import guru.springframework.sfg_di.controllers.SetterInjectedController;
import io.micrometer.observation.transport.Propagator;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());
		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("----- Primary Bean");

		String greeting = myController.sayHello();

		System.out.println(greeting);

		System.out.println("----- Property");

		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----- Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----- Constructor");

		ConstructorInjectedController
				constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());
	}

}
