package ticket2.ticket2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ticket2.ticket2.model.Venue;

public interface VenueRepository extends JpaRepository<Venue, Long> {

}