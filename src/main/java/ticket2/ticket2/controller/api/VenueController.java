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

import ticket2.ticket2.model.Venue;
import ticket2.ticket2.service.VenueService;

@RestController
@RequestMapping("/venue")
@CrossOrigin
public class VenueController {

    @Autowired
    VenueService venueService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Venue>> getAllVenues() {
        return new ResponseEntity<>(venueService.getAllVenues(), HttpStatus.OK);
    }

    // GET BAND BY ID
    @GetMapping("/id")
    public ResponseEntity<Venue> getVenueById(@RequestParam Long id) {
        return new ResponseEntity<>(venueService.getVenueById(id), HttpStatus.OK);
    }

    // POST A BAND
    @PostMapping("/create")
    public ResponseEntity<Venue> createVenue(@RequestBody Venue newVenue) {
        return new ResponseEntity<>(venueService.createVenue(newVenue), HttpStatus.CREATED);
    }

    // DELETE BY ID
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteVenueById(@RequestParam Long id) {
        venueService.deleteVenueById(id);
        return new ResponseEntity<>("Venue deleted", HttpStatus.OK);
    }

    // UPDATE BY ID
    @PutMapping("/update")
    public ResponseEntity<Venue> updateVenueById(@RequestParam Long id, @RequestBody Venue newVenue) {
        return new ResponseEntity<>(venueService.updateVenueById(id, newVenue), HttpStatus.OK);
    }

}