package ticket2.ticket2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ticket2.ticket2.model.Band;
import ticket2.ticket2.repository.BandRepository;

@Service
public class BandService {

    @Autowired
    BandRepository bandRepository;

    // GET ALL BANDS
    public List<Band> getAllBands() {
        return bandRepository.findAll();
    }

    // GET BAND BY ID
    public Band getBandById(Long id) {
        return bandRepository.findById(id).get();
    }

    // POST BAND
    public Band createBand(Band band) {
        return bandRepository.save(band);
    }

    // POST LIST OF BAND +++PROVA TRY AND CATCH+++
    public List<Band> createListOfBands(List<Band> bands) {
        return bandRepository.saveAll(bands);
    }

    // DELETE BY ID
    // +++ AGGIORNARE +++
    public void deleteBandById(Long id) {
        bandRepository.deleteById(id);
    }

    // UPDATE BAND BY ID
    public Band updateBandById(Long id, Band newBand) {
        Optional<Band> oldBandOpt = bandRepository.findById(id);

        if (oldBandOpt.isPresent()) {
            Band oldBand = oldBandOpt.get();

            oldBand.setBand(newBand.getBand());
            oldBand.setGigs(newBand.getGigs());
            oldBand.setNationality(newBand.getNationality());

            return bandRepository.save(oldBand);
        }

        return null;
    }

}
