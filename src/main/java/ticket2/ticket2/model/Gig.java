package ticket2.ticket2.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Gig {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private LocalDateTime date;

    @Column
    private String country;

    @Column
    private String city;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_band_id")
    private Band band;
    // JoinColumn ---> goes in the tables owner of the relationship (has a column with foreign keys)
    // (name = "fk_band_id") ---> the name this column will have in DB (will have fk inside)

    @ManyToOne
    @JoinColumn(name = "fk_venue_id")
    private Venue venue;

    @OneToMany
    (mappedBy = "gig")
    @JsonIgnore
    private List<Ticket> tickets;

    public Gig(LocalDateTime date, String country, String city, Band band, Venue venue, List<Ticket> tickets) {
        this.date = date;
        this.country = country;
        this.city = city;
        this.band = band;
        this.venue = venue;
        this.tickets = tickets;
    }
}
