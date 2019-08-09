package cloudbees.example.templates_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.text.*;



@RestController

public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Java Code Geeks!" + getDate;
    }

     @GetMapping("/")
    public String sayHelloToALL() {
        return "Hello Java Code Geeks!" + getDate;
    }
    
    
    Public String getDate(){
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date); //2013/10/15 16:16:39


    }
