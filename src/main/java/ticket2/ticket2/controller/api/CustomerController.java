package ticket2.ticket2.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ticket2.ticket2.model.Customer;
import ticket2.ticket2.service.CustomerService;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @Autowired
    CustomerService customerService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    // GET BAND BY ID
    @GetMapping("/id")
    public ResponseEntity<Customer> getCustomerById(@RequestParam Long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    // POST A BAND
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer newCustomer) {
        return new ResponseEntity<>(customerService.createCustomer(newCustomer), HttpStatus.CREATED);
    }

    // DELETE BY ID
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteCustomerById(@RequestParam Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }

    // UPDATE BY ID
    @PutMapping("/update")
    public ResponseEntity<Customer> updateCustomerById(@RequestParam Long id, @RequestBody Customer newCustomer) {
        return new ResponseEntity<>(customerService.updateCustomerById(id, newCustomer), HttpStatus.OK);
    }

}
