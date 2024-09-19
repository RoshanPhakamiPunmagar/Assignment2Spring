package com.example.databasedao;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/user")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<Customer>> retrieveAll() {
        List<Customer> movies = customerService.getAllCustomers();

        return ResponseEntity.ok(movies);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Customer> retrieveById(@RequestParam Long id) {
        Customer customer =  customerService.getCustomerById(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.postCustomer(customer);
        return ResponseEntity.ok(createdCustomer);
    }
    
     @GetMapping("/getByEmail/{email}")
    public Customer getByEmail(@RequestParam String email)
    {
        return customerService.getByEmail(email);
    }
    
    /*
      @PostMapping("/addCustomer")
    @ResponseBody
    public ResponseEntity<Void> addCustomer(@RequestBody Customer customer) {
        System.out.println("Debug: " + customer);
        customerService.addCustomer(customer);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
*/
}
