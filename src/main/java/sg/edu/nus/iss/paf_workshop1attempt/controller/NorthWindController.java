package sg.edu.nus.iss.paf_workshop1attempt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.paf_workshop1attempt.model.Customer;
import sg.edu.nus.iss.paf_workshop1attempt.service.customerSvc;

@Controller
public class NorthWindController {

    @Autowired
    private customerSvc svc;
 
    @GetMapping(path="/api/customers", consumes="application/json")
    public List<Customer> getLimitedCustomers(@RequestParam(name="limit", defaultValue = "5") int limit, @RequestParam(name="Offset",defaultValue = "0") int offset) {
    
        return svc.getLimitedCustomers(limit, offset);
    }

    @GetMapping(path="/api/customer/{custId}", consumes="application/json")
    public Customer getCustomerById(@PathVariable(name="custID") int custID ) {
        return svc.getCustomerById(custID);
    }

    @GetMapping(path="/api/customer/{custId}/orders", consumes="application/json")
    public Customer getOrdersById(@PathVariable(name="custID") int custID ) {
        return svc.getCustomerById(custID);
    }




}
