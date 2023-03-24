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

import ticket2.ticket2.model.Ticket;
import ticket2.ticket2.service.TicketService;

@RestController
@RequestMapping("/ticket")
@CrossOrigin
public class TicketController {

    @Autowired
    TicketService ticketService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }

    // GET BAND BY ID
    @GetMapping("/id")
    public ResponseEntity<Ticket> getTicketById(@RequestParam Long id) {
        return new ResponseEntity<>(ticketService.getTicketById(id), HttpStatus.OK);
    }

    // POST A BAND
    @PostMapping("/create")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket newTicket) {
        return new ResponseEntity<>(ticketService.createTicket(newTicket), HttpStatus.CREATED);
    }

    // DELETE BY ID
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteTicketById(@RequestParam Long id) {
        ticketService.deleteTicketById(id);
        return new ResponseEntity<>("Ticket deleted", HttpStatus.OK);
    }

    // UPDATE BY ID
    @PutMapping("/update")
    public ResponseEntity<Ticket> updateTicketById(@RequestParam Long id, @RequestBody Ticket newTicket) {
        return new ResponseEntity<>(ticketService.updateTicketById(id, newTicket), HttpStatus.OK);
    }

}
