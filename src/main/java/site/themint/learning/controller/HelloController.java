package site.themint.learning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.themint.learning.service.CustomerService;

import java.util.List;

@RestController
@RequestMapping("api")
public class HelloController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/")
    public String helloController(){
        return "Hello World multi stage yml build docker deploy 2027";
    }

    @GetMapping("customers")
    public List<CustomerService.customer> getCustomers(){
        return customerService.getCustomers();
    }
    @GetMapping("version")
    public String getVersion(){
        return "1.4";
    }
}