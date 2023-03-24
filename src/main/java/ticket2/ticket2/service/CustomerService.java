package ticket2.ticket2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket2.ticket2.model.Customer;
import ticket2.ticket2.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    
    // GET ALL CUSTOMERS
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    // GET CUSTOMER BY ID
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    // POST CUSTOMER
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    // POST LIST OF CUSTOMER 
    // +++PROVA TRY AND CATCH+++
    public List<Customer> createListOfCustomers(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    // DELETE CUSTOMER BY ID
    // +++ AGGIORNARE +++
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    // UPDATE CUSTOMER BY ID
    public Customer updateCustomerById(Long id, Customer newCustomer) {
        Optional<Customer> oldCustomerOpt = customerRepository.findById(id);

        if (oldCustomerOpt.isPresent()) {
            Customer oldCustomer = oldCustomerOpt.get();

            oldCustomer.setFull_name(newCustomer.getFull_name());   
            oldCustomer.setEmail(newCustomer.getEmail());
            oldCustomer.setNationality(newCustomer.getNationality());
            oldCustomer.setTickets(newCustomer.getTickets());

            return customerRepository.save(oldCustomer);
        }

        return null;
    }

}
