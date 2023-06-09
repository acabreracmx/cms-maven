package com.acabreracmx.cms.controllers;

import com.acabreracmx.cms.entities.Customer;
import com.acabreracmx.cms.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/view")
    public String ViewHomePage(Model model){
        model.addAttribute("listCustomers", customerService.getCustomers());
        return "index";
    }

    /**
     * Gets the HTTP response for the get request of all customers.
     *
     * @return The HTTP response for the get request of all customers.
     */
    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.getCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    /**
     * Gets the HTTP response for the get request of a customer by the id.
     *
     * @param id The id of the customer of the get request.
     *
     * @return The HTTP response for the get request for the given customer id.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") int id) {
        Customer customer = customerService.getCustomerById(id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    /**
     * Adds a new customer.
     *
     * @param customer The request body of the customer to add.
     *
     * @return The HTTP response of the customer to add.
     */
    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer customerToAdd = customerService.addCustomer(customer);
        return new ResponseEntity<>(customerToAdd, HttpStatus.OK);
    }

    /**
     * Updates a customer.
     *
     * @param customer The request body of the customer to update.
     *
     * @return The HTTP response of the customer to update.
     */
    @PutMapping
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        Customer customerToAdd = customerService.addCustomer(customer);
        return new ResponseEntity<>(customerToAdd, HttpStatus.OK);
    }

    /**
     * Deletes the customer identified by the given id.
     * @param id The id of the customer to delete.
     */
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomerById(id);
    }
}
