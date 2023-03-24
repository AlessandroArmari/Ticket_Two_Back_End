package ticket2.ticket2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket2.ticket2.model.Venue;
import ticket2.ticket2.repository.VenueRepository;

@Service
public class VenueService {

    @Autowired
    VenueRepository venueRepository;

    // GET ALL
    public List<Venue> getAllVenues() {
        return venueRepository.findAll();
    }

    // GET BY ID
    public Venue getVenueById(Long id) {
        return venueRepository.findById(id).get();
    }

    // POST VENUE
    public Venue createVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    // POST LIST OF VENUE +++PROVA TRY E CATCH+++
    public List<Venue> creteListOfVenues(List<Venue> venues) {
        return venueRepository.saveAll(venues);
    }

    // DELETE VENUE BY ID
    public void deleteVenueById(Long id) {
        venueRepository.deleteById(id);
    }

    // UPDATE VENUE BY ID
    public Venue updateVenueById(Long id, Venue newVenue) {
        Optional<Venue> oldVenueOpt = venueRepository.findById(id);

        if(oldVenueOpt.isPresent()){
            Venue oldVenue=oldVenueOpt.get();
            oldVenue.setVenue(newVenue.getVenue());
            oldVenue.setGigs(newVenue.getGigs());
            oldVenue.setCountry(newVenue.getCountry());
            oldVenue.setTown(newVenue.getTown());
            oldVenue.setMaxTicket(newVenue.getMaxTicket());

            return venueRepository.save(oldVenue);
            
        }

        return null;
    }
}
