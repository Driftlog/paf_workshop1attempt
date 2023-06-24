package sg.edu.nus.iss.paf_workshop1attempt.repo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_workshop1attempt.model.Customer;

@Repository
public class CustomerRepo {
    
    @Autowired
    private JdbcTemplate template;

    private final String getAllSQL = "select * from customers";

    private final String getById = "select * from customers where id = ?";

    private final String getLimitedSQL = "select * from customers limit ? offset ?";
   
    private final String getOrdersSQL = "select * from orders where customer_id = ?";

    public List<Customer> getAll() {
        final SqlRowSet rs = template.queryForRowSet(getAllSQL);

        final List<Customer> customers = new ArrayList<>();

        while (rs.next()) {
            Customer customer = new Customer();
            customer.setCompany(rs.getString("company"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setJobTitle(rs.getString("job_title"));
            customer.setId(rs.getInt("id"));

            customers.add(customer);
        }

        return customers;
    }

    public Customer getCustomerById(int id) {
        
        Customer customer = new Customer();
        customer = template.queryForObject(getById, BeanPropertyRowMapper.newInstance(Customer.class), id);
        return customer;
    }

    public List<Customer> getLimitedCustomer(int limit, int offset) {

        RowMapper<Customer> rowMapper = (rs, rowNum) -> {
            Customer customer = new Customer();
            customer.setCompany(rs.getString("company"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setJobTitle(rs.getString("job_title"));
            customer.setId(rs.getInt("id"));

            return customer;
        };
        
        List<Customer> customers = template.query(getLimitedSQL, rowMapper,
        limit, offset);

        return (Collections.unmodifiableList(customers));
    }

        
    
}
