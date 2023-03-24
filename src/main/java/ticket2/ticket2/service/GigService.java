package ticket2.ticket2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket2.ticket2.model.Gig;
import ticket2.ticket2.repository.GigRepository;

@Service
public class GigService {

    @Autowired
    GigRepository gigRepository;

    // GET ALL
    public List<Gig> getAllGigs() {
        return gigRepository.findAll();
    }

    // GET BY ID
    public Gig getGigById(Long id) {
        return gigRepository.findById(id).get();
    }

    // POST BAND
    public Gig createGig(Gig gig) {
        return gigRepository.save(gig);
    }

    // POST LIST OF BAND +++PROVA TRY AND CATCH+++
    public List<Gig> createListOfGigs(List<Gig> gigs) {
        return gigRepository.saveAll(gigs);
    }

    // DELETE BY ID
    // +++ AGGIORNARE +++
    public void deleteGigById(Long id) {
        gigRepository.deleteById(id);
    }


    //UPDATE BY ID
    public Gig updateGigById(Long id, Gig newGig) {
        Optional<Gig> oldGigOpt = gigRepository.findById(id);

        if (oldGigOpt.isPresent()) {
            Gig oldGig = oldGigOpt.get();
            oldGig.setDate(newGig.getDate());
            oldGig.setBand(newGig.getBand());
            oldGig.setCountry(newGig.getCountry());
            oldGig.setCity(newGig.getCity());
            oldGig.setTickets(newGig.getTickets());
            oldGig.setVenue(newGig.getVenue());

            return gigRepository.save(oldGig);
        }

        return null;

    }

}
