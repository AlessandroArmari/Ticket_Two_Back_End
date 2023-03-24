package ticket2.ticket2.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String venue;

    @Column
    private int maxTicket;

    @Column
    private String country;

    @Column
    private String town;

    @OneToMany
    (mappedBy = "venue")
    @JsonIgnore
    private List<Gig> gigs;

    public Venue(String venue, int maxTicket, String country, String town, List<Gig> gigs) {
        this.venue = venue;
        this.maxTicket = maxTicket;
        this.country = country;
        this.town = town;
        this.gigs = gigs;
    }

}
