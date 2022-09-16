package com.luv2code.springdemo.Rest;

import com.luv2code.springdemo.Exceptions.CustomersNotFoundException;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    //getting a unique customer
    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id){
    Customer theCustomer = customerService.getCustomer(id);
     if (theCustomer == null){
         throw new CustomersNotFoundException("Customer id not found -"+id);
     }
       return customerService.getCustomer(id);
    }

     // add mapping for Post / Customers - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer){
        // also just in case the pass an id in Json.... set id to 0
        // this is force a save of new item....instead of update


        //if the id is zero therefore the dao will inset the customer in the database
        theCustomer.setId(0);

        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    // add mapping for PUT / Customers - update existing customer
    @PutMapping("/customers")
    public Customer UpdateCustomer(@RequestBody Customer theCustomer) {
        customerService.saveCustomer(theCustomer);

        return theCustomer;
    }

    @DeleteMapping("/customers/{id}")
    public String  deleteCustomer(@PathVariable int id){

        Customer theCustomer = customerService.getCustomer(id);
        if (theCustomer == null){
            throw new CustomersNotFoundException("Customer id not found -"+id);
        }

        customerService.deleteCustomer(id);

        return "Deleted customer id -"+id;

    }





}
