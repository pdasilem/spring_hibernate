package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User("Petr", "Lavockin", "petya@gmail.com")
              .setCar(new Car("Peugeot", 123)));
      userService.add(new User("Vasya", "Skameykin", "vasya@gmail.com")
              .setCar(new Car("Renault", 345)));
      userService.add(new User("Kolya", "Taburetkin", "kolya@gmail.com")
              .setCar(new Car("Citroen", 678)));

       List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar().toString());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("Renault", 345));

      context.close();
   }
}
