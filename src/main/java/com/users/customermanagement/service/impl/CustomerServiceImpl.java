package com.users.customermanagement.service.impl;

import com.users.customermanagement.model.Customer;
import com.users.customermanagement.repository.CustomerRepository;
import com.users.customermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;


    @Override
    public List<Customer> getAll() {
        return repository.findAll();
    }

    @Override
    public Customer getById(Long id) {
        return repository.findById(id).orElseThrow(()-> new RuntimeException("id is Null"));
    }

    @Override
    public Customer update(Customer customerRequest, Long id) {
        Customer customer = repository.findById(id).orElseThrow(()-> new RuntimeException("id is Null"));
        customer.setId(id);
        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setEmail(customerRequest.getEmail());
        return repository.save(customer);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Customer save(Customer customerRequest) {
        return repository.save(customerRequest);
    }
}
