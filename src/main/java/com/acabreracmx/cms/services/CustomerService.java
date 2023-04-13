package com.acabreracmx.cms.services;

import com.acabreracmx.cms.entities.Customer;
import com.acabreracmx.cms.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).
                orElseThrow(() -> new RuntimeException("The requested customer could not be found."));
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomerById(int id) {
        customerRepository.deleteById(id);
    }
}
