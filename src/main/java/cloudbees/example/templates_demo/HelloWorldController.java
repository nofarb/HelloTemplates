package cloudbees.example.templates_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.text.*;



@RestController

public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Java Code Geeks! this is feature1 branch . another change " + "Time is :  " + getCurrentDateTime();
    }

     @GetMapping("/")
    public String sayHelloToALL() {
        return "Hello Java Code Geeks! this is feature1 branch . " + "Time is :  " + getCurrentDateTime();
    }
    
    
    public String getCurrentDateTime() {
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            // get current date time with Date()
            Date date = new Date();
            return dateFormat.format(date);

    }


  }
