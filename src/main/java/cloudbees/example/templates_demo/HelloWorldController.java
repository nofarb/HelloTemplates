package cloudbees.example.templates_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.text.*;



@RestController

public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Java Code Geeks!" + "Time is :" + getCurrentDateTime();
    }

     @GetMapping("/")
    public String sayHelloToALL() {
        return "Hello Java Code Geeks!" + "Time is :" + getCurrentDateTime();
    }
    
    
    public String getCurrentDateTime() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            // get current date time with Date()
            Date date = new Date();
            return dateFormat.format(date);

    }


  }
