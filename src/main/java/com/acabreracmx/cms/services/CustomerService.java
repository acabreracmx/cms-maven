package com.acabreracmx.cms.services;

import com.acabreracmx.cms.entities.Customer;

import java.util.List;

/**
 * Interface for service classes of Customer objects.
 */
public interface CustomerService {
    /**
     * Returns a list containing all customers.
     *
     * @return The list of all customers.
     */
    public List<Customer> getCustomers();

    /**
     * Returns the Customer object by the given id.
     *
     * @param id The id of the customer to return.
     *
     * @return The desired customer.
     */
    public Customer getCustomerById(int id);

    /**
     * Adds a customer object.
     *
     * @param customer The customer to add.
     *
     * @return The customer to add.
     */
    public Customer addCustomer(Customer customer);

    /**
     * Deletes the Customer by the given id.
     *
     * @param id The id of the customer to delete.
     */
    public void deleteCustomerById(int id);
}
