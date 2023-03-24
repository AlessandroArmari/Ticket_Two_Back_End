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
public class Band {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String band;

    @Column
    private String nationality;

    @OneToMany
    (mappedBy = "band")
    @JsonIgnore
    private List<Gig> gigs;
    //mappedBy is the other side of @JoinColumn
    //this means this table doesn't have a column with foreign keys
    // (mappedBy = "band") ---> "band" is the "JAVA" name of "private Band band;" in Gig class
    // @JsonIgnore---> avoid the issue of the infinite loop when doing GET (DON'T PRINT GIGS when GETting bands!)

    public Band(String band, String nationality, List<Gig> gigs) {
        this.band = band;
        this.nationality = nationality;
        this.gigs = gigs;
    }

}
