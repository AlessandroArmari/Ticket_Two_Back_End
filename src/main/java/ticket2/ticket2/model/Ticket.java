package ticket2.ticket2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String ticketCode;

    @Column
    private boolean Paper;

    @ManyToOne
    @JoinColumn(name="fk_gig_id")
    private Gig gig;

    @ManyToOne
    @JoinColumn(name = "fk_customer_id")
    private Customer customer;

    public Ticket(String ticketCode, boolean Paper, Gig gig, Customer customer) {
        this.ticketCode = ticketCode;
        this.Paper = Paper;
        this.gig = gig;
        this.customer = customer;
    }

    public Boolean getPaper() {
        return Paper;
    }

}
