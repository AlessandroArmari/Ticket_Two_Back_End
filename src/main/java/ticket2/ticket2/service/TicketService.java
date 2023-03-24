package ticket2.ticket2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket2.ticket2.model.Ticket;
import ticket2.ticket2.repository.TicketRepository;

@Service
public class TicketService {

    @Autowired
    TicketRepository ticketRepository;

    // GET ALL TICKETS
    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    // GET TICKET BY ID
    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id).get();
    }

    //POST TICKET
    public Ticket createTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    //POST LIST OF TICKET
    public List<Ticket> createListOfTickets(List<Ticket> tickets){
        return ticketRepository.saveAll(tickets);
    }

    //DELETE TICKET BY ID
    //+++ AGGIORNARE +++
    public void deleteTicketById(Long id){
        ticketRepository.deleteById(id);
    }

    //UPDATE TICKET BY ID
    public Ticket updateTicketById(Long id, Ticket newTicket){
        Optional<Ticket> oldTicketOpt = ticketRepository.findById(id);

        if(oldTicketOpt.isPresent()) {
            Ticket oldTicket = oldTicketOpt.get();
            oldTicket.setTicketCode(newTicket.getTicketCode());
            oldTicket.setPaper(newTicket.getPaper());
            oldTicket.setCustomer(newTicket.getCustomer());
            oldTicket.setGig(newTicket.getGig());

            return ticketRepository.save(oldTicket);
        }

        return null;
    }


}
