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

import ticket2.ticket2.model.Gig;
import ticket2.ticket2.service.GigService;

@RestController
@RequestMapping("/gig")
@CrossOrigin
public class GigController {

    @Autowired
    GigService gigService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Gig>> getAllGigs() {
        return new ResponseEntity<>(gigService.getAllGigs(), HttpStatus.OK);
    }

    // GET BAND BY ID
    @GetMapping("/id")
    public ResponseEntity<Gig> getGigById(@RequestParam Long id) {
        return new ResponseEntity<>(gigService.getGigById(id), HttpStatus.OK);
    }

    // POST A BAND
    @PostMapping("/create")
    public ResponseEntity<Gig> createGig(@RequestBody Gig newGig) {
        return new ResponseEntity<>(gigService.createGig(newGig), HttpStatus.CREATED);
    }

    // DELETE BY ID
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteGigById(@RequestParam Long id) {
        gigService.deleteGigById(id);
        return new ResponseEntity<>("Gig deleted", HttpStatus.OK);
    }

    // UPDATE BY ID
    @PutMapping("/update")
    public ResponseEntity<Gig> updateGigById(@RequestParam Long id, @RequestBody Gig newGig) {
        return new ResponseEntity<>(gigService.updateGigById(id, newGig), HttpStatus.OK);
    }

}
