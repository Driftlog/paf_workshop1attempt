package sg.edu.nus.iss.paf_workshop1attempt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_workshop1attempt.model.Customer;
import sg.edu.nus.iss.paf_workshop1attempt.repo.CustomerRepo;

@Service
public class customerSvc {
    
    @Autowired
    private CustomerRepo repo;

    public List<Customer> getAll() {
        return repo.getAll();
    }

    public Customer getCustomerById(int id) {
        return repo.getCustomerById(id);
    }
    
    public List<Customer> getLimitedCustomers(final int limit, final int offset) {
        return repo.getLimitedCustomer(limit, offset);
    }
}
