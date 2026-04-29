package site.themint.learning.service;

import org.springframework.stereotype.Service;
import site.themint.learning.model.Customer;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerService {

    public record customer(
        String name,
        String address,
        Integer mobileNumber
    ){}
    public List<customer> getCustomers(){
        //Customer c1 = new Customer("Shrikant", "Voorburg", 123214324);
        List<customer> customers = Arrays.asList(
                new customer("Shrikant", "Voorburg", 1232143),
                new customer("Shanvi", "Noorpur", 645645654),
                new customer("Sarita", "Ghazipur", 423433324),
                new customer("Pyush", "Voorburg", 1235672143)
        );
        return customers;
    }
}
