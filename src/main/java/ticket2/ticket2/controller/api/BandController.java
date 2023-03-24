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

import ticket2.ticket2.model.Band;
import ticket2.ticket2.service.BandService;
//dddd
@RestController
@RequestMapping("/band")
@CrossOrigin
public class BandController {

    @Autowired
    BandService bandService;

    // GET ALL
    @GetMapping("/all")
    public ResponseEntity<List<Band>> getAllBands() {
        return new ResponseEntity<>(bandService.getAllBands(), HttpStatus.OK);
    }

    // GET BAND BY ID
    @GetMapping("/id")
    public ResponseEntity<Band> getBandById(@RequestParam Long id) {
        return new ResponseEntity<>(bandService.getBandById(id), HttpStatus.OK);
    }

    // POST A BAND
    @PostMapping("/create")
    public ResponseEntity<Band> createBand(@RequestBody Band newBand) {
        return new ResponseEntity<>(bandService.createBand(newBand), HttpStatus.CREATED);
    }

    // DELETE BY ID
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBandById(@RequestParam Long id) {
        bandService.deleteBandById(id);
        return new ResponseEntity<>("Band deleted", HttpStatus.OK);
    }

    // UPDATE BY ID
    @PutMapping("/update")
    public ResponseEntity<Band> updateBandById(@RequestParam Long id, @RequestBody Band newBand) {
        return new ResponseEntity<>(bandService.updateBandById(id, newBand), HttpStatus.OK);
    }

}
