package ticket2.ticket2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ticket2.ticket2.model.Band;
import ticket2.ticket2.model.Customer;
import ticket2.ticket2.model.Gig;
import ticket2.ticket2.model.Ticket;
import ticket2.ticket2.model.Venue;
import ticket2.ticket2.service.BandService;
import ticket2.ticket2.service.CustomerService;
import ticket2.ticket2.service.GigService;
import ticket2.ticket2.service.TicketService;
import ticket2.ticket2.service.VenueService;

@Component
public class DataLoadRunner implements CommandLineRunner {

        @Autowired
        BandService bandService;

        @Autowired
        VenueService venueService;

        @Autowired
        GigService gigService;

        @Autowired
        CustomerService customerService;

        @Autowired
        TicketService ticketService;

        public void run(String... args) throws Exception {

                // CREATING BANDS
                Band guns_n_roses = new Band("Guns 'n Roses", "US", null);
                Band deep_purple = new Band("Deep Purple", "UK", null);
                Band bruce_springsteen = new Band("Bruce Springsteen", "US", null);
                Band iron_maiden = new Band("Iron Maiden", "UK", null);
                Band vasco_rossi = new Band("Vasco Rossi", "IT", null);
                Band kiss = new Band("Kiss", "US", null);
                Band metallica = new Band("Metallica", "US", null);

                // CREATING LIST of BAND
                List<Band> bandList = new ArrayList<Band>();
                bandList.addAll(
                                Arrays.asList(guns_n_roses, deep_purple, bruce_springsteen, iron_maiden, vasco_rossi,
                                                kiss, metallica));

                // ADDING LIST OF BANDS TO SERVER
                bandService.createListOfBands(bandList);

                // ++++++++++++++++++++++++++++++++++++++++++++++++++++

                // CREATING VENUES
                Venue circo_massimo = new Venue("Circo Massimo", 70000, "IT", "Rome", null);
                Venue johan_cruijff_arena = new Venue("Johan Cruijff Arena", 72000, "NL", "Amsterdam", null);
                Venue arena_sferisterio = new Venue("Arena Sferisterio", 3000, "IT", "Macerata", null);
                Venue piazza_napoleone = new Venue("Piazza Napoleone", 7000, "IT", "Lucca", null);
                Venue stadio_olimpico = new Venue("Stadio Olimpico", 69000, "IT", "Rome", null);
                Venue tauron_arena = new Venue("Tauron Arena", 22000, "PL", "Krakow", null);
                Venue arena02 = new Venue("02 Arena", 20000, "UK", "London", null);
                Venue hyde_park = new Venue("Hyde Park", 65000, "UK", "London", null);

                // CREATING LIST of VENUES
                List<Venue> venueList = new ArrayList<Venue>();
                venueList.addAll(Arrays.asList(circo_massimo, johan_cruijff_arena, arena_sferisterio, piazza_napoleone,
                                stadio_olimpico, tauron_arena, arena02, hyde_park));

                // SAVING LIST OF VENUE
                venueService.creteListOfVenues(venueList);

                // ++++++++++++++++++++++++++++++++++++++++++++++++++++

                // CREATING CUSTOMERS (without Tickets, so far)

                Customer customer1 = new Customer("Alessandro Armari", "alex.mani@gmail.com", "IT", null);
                Customer customer2 = new Customer("Marco Armari", "marco_meni@libero.com", "IT", null);
                Customer customer3 = new Customer("Livio Setaro", "roxaslama@gmail.com", "IT", null);
                Customer customer4 = new Customer("Francesco Musca", "fra_fiot7@hotmail.it", "IT", null);
                Customer customer5 = new Customer("John Red", "power_ranger_00@msn.it", "UK", null);
                Customer customer6 = new Customer("Alex Van Basten", "vannyBasten@outlook.com", "NL", null);
                Customer customer7 = new Customer("Dimitri Laschenkov", "dimy_vodka@02.pl", "PL", null);
                Customer customer8 = new Customer("Gianni Metello", "giack_smerli@gmail.com", "IT", null);
                Customer customer9 = new Customer("Rossana Rossi", "red_rossana99@fastweb.it", "IT", null);
                Customer customer10 = new Customer("Donald Trump", "armageddon_donny@fox.us", "US", null);
                Customer customer11 = new Customer("Francesca Esposito", "fra77@libero.it", "IT", null);
                Customer customer12 = new Customer("Remo Tavoli", "tables_rain@gmail.com", "IT", null);
                Customer customer13 = new Customer("Van Beren Jack", "jackie_jackHOLL@katawiki.com", "NL", null);
                Customer customer14 = new Customer("Oliver Ark", "olli_olli2@giffgaff.uk", "UK", null);
                Customer customer15 = new Customer("Giacomo esposito", "relicHunter@gmail.com", "IT", null);
                Customer customer16 = new Customer("Sabrina Salerno", "sabryHot@email.it", "IT", null);
                Customer customer17 = new Customer("Rosa Di Carmine", "sunshine@gmail.com", "IT", null);

                // SAVING LIST OF CUSTOMER TO DB
                List<Customer> customerList = new ArrayList<Customer>();
                customerList.addAll(Arrays.asList(customer1, customer2, customer3, customer4, customer5, customer6,
                                customer7,
                                customer8, customer9, customer10, customer11, customer12, customer13, customer14,
                                customer15,
                                customer16, customer17));
                customerService.createListOfCustomers(customerList);

                // ++++++++++++++++++++++++++++++++++++++++++++++++++++

                // CREATE GIGS

                // METALLICA

                // LocalDateTime NEEDS 2 PARAMETERS
                // --->LocalDate
                // --->LocalTime

                LocalDate metallicaLocalDate1 = LocalDate.of(2023, 04, 27);
                LocalTime metallicaLocalTime1 = LocalTime.of(20, 30);

                LocalDate metallicaLocalDate2 = LocalDate.of(2023, 04, 29);
                LocalTime metallicaLocalTime2 = LocalTime.of(20, 30);

                // Now I create LocalDateTime using 2 parameteres
                LocalDateTime metallicaLocaldatetime1 = LocalDateTime.of(metallicaLocalDate1, metallicaLocalTime1);
                LocalDateTime metallicaLocaldatetime2 = LocalDateTime.of(metallicaLocalDate2, metallicaLocalTime2);

                // CREATING GIGS
                Gig metallicaGig1 = new Gig(metallicaLocaldatetime1, "NL", "Amsterdam", metallica, tauron_arena, null);
                Gig metallicaGig2 = new Gig(metallicaLocaldatetime2, "NL", "Amsterdam", metallica, tauron_arena, null);

                // CREATING LIST OF GIGS
                List<Gig> metallicaGigs = new ArrayList<Gig>();
                metallicaGigs.addAll(Arrays.asList(metallicaGig1, metallicaGig2));

                // SAVING LIST OF GIGS
                gigService.createListOfGigs(metallicaGigs);

                

                // IRON MAIDEN

                LocalDate ironMaidenLocalDate1 = LocalDate.of(2023, 06, 13);
                LocalTime ironMaidenLocalTime1 = LocalTime.of(20, 00);

                LocalDate ironMaidenLocalDate2 = LocalDate.of(2023, 06, 14);
                LocalTime ironMaidenLocalTime2 = LocalTime.of(20, 00);

                LocalDateTime ironMaidenLocalDateTime1 = LocalDateTime.of(ironMaidenLocalDate1, ironMaidenLocalTime1);
                LocalDateTime ironMaidenLocalDateTime2 = LocalDateTime.of(ironMaidenLocalDate2, ironMaidenLocalTime2);

                Gig ironMaidenGig1 = new Gig(ironMaidenLocalDateTime1, "PL", "Krakow", iron_maiden, tauron_arena, null);
                Gig ironMaidenGig2 = new Gig(ironMaidenLocalDateTime2, "PL", "Krakow", iron_maiden, tauron_arena, null);

                List<Gig> ironMaidenGigs = new ArrayList<Gig>();
                ironMaidenGigs.addAll(Arrays.asList(ironMaidenGig1, ironMaidenGig2));

                gigService.createListOfGigs(ironMaidenGigs);
                

                // Guns 'n Roses

                LocalDate gunsRosesLocalDate1 = LocalDate.of(2023, 07, 8);
                LocalTime gunsRosesLocalTime1 = LocalTime.of(20, 45);
                LocalDateTime gunsRosesLocalDateTime1 = LocalDateTime.of(gunsRosesLocalDate1, gunsRosesLocalTime1);
                Gig gunsRosesGig1 = new Gig(gunsRosesLocalDateTime1, "IT", "Rome", guns_n_roses, circo_massimo, null);

                LocalDate gunsRosesLocalDate2 = LocalDate.of(2023, 06, 30);
                LocalTime gunsRosesLocalTime2 = LocalTime.of(14, 00);
                LocalDateTime gunsRosesLocalDateTime2 = LocalDateTime.of(gunsRosesLocalDate2, gunsRosesLocalTime2);
                Gig gunsRosesGig2 = new Gig(gunsRosesLocalDateTime2, "UK", "London", guns_n_roses, hyde_park, null);

                List<Gig> gunsRosesGigs = new ArrayList<Gig>();
                gunsRosesGigs.addAll(Arrays.asList(gunsRosesGig1, gunsRosesGig2));

                gigService.createListOfGigs(gunsRosesGigs);
                
                // DEEP PURPLE
                LocalDate deepPurpleLocalDate1 = LocalDate.of(2023, 06, 29);
                LocalTime deepPurpleLocalTime1 = LocalTime.of(21, 00);
                LocalDateTime deepPurpleLocalDateTime1 = LocalDateTime.of(deepPurpleLocalDate1, deepPurpleLocalTime1);

                Gig deepPurpleGig1 = new Gig(deepPurpleLocalDateTime1, "IT", "Macerata", deep_purple, arena_sferisterio,
                                null);
                List<Gig> deepPurpleGigs = new ArrayList<Gig>();
                deepPurpleGigs.addAll(Arrays.asList(deepPurpleGig1));

                gigService.createListOfGigs(deepPurpleGigs);
                

                // BRUCE SPRINGSTEEN

                LocalDate bruceSpringsteenLocalDate1 = LocalDate.of(2023, 05, 21);
                LocalTime bruceSpringsteenLocalTime1 = LocalTime.of(19, 30);
                LocalDateTime bruceSpringsteenLocalDateTime1 = LocalDateTime.of(
                                bruceSpringsteenLocalDate1, bruceSpringsteenLocalTime1);
                Gig bruceSpringsteenGig1 = new Gig(
                                bruceSpringsteenLocalDateTime1, "IT", "Rome", bruce_springsteen, circo_massimo, null);

                LocalDate bruceSpringsteenLocalDate2 = LocalDate.of(2023, 05, 25);
                LocalTime bruceSpringsteenLocalTime2 = LocalTime.of(19, 30);
                LocalDateTime bruceSpringsteenLocalDateTime2 = LocalDateTime.of(
                                bruceSpringsteenLocalDate2, bruceSpringsteenLocalTime2);
                Gig bruceSpringsteenGig2 = new Gig(
                                bruceSpringsteenLocalDateTime2, "NL", "Amsterdam", bruce_springsteen,
                                johan_cruijff_arena, null);

                LocalDate bruceSpringsteenLocalDate3 = LocalDate.of(2023, 05, 27);
                LocalTime bruceSpringsteenLocalTime3 = LocalTime.of(19, 30);
                LocalDateTime bruceSpringsteenLocalDateTime3 = LocalDateTime.of(
                                bruceSpringsteenLocalDate3, bruceSpringsteenLocalTime3);
                Gig bruceSpringsteenGig3 = new Gig(
                                bruceSpringsteenLocalDateTime3, "NL", "Amsterdam", bruce_springsteen,
                                johan_cruijff_arena, null);

                List<Gig> bruceSpringsteenGigs = new ArrayList<Gig>();
                bruceSpringsteenGigs.addAll(
                                Arrays.asList(bruceSpringsteenGig1, bruceSpringsteenGig2, bruceSpringsteenGig3));

                gigService.createListOfGigs(bruceSpringsteenGigs);
                

                // VASCO ROSSI

                LocalDate vascoRossiLocalDate1 = LocalDate.of(2023, 06, 16);
                LocalTime vascoRossiLocalTime1 = LocalTime.of(21, 00);
                LocalDateTime vascoRossiLocalDateTime1 = LocalDateTime.of(vascoRossiLocalDate1, vascoRossiLocalTime1);
                Gig vascoRossiGig1 = new Gig(vascoRossiLocalDateTime1, "IT", "Rome", vasco_rossi, stadio_olimpico,
                                null);

                List<Gig> vascoRossiGigs = new ArrayList<Gig>();
                vascoRossiGigs.addAll(Arrays.asList(vascoRossiGig1));
                gigService.createListOfGigs(vascoRossiGigs);
                

                // KISS

                LocalDate kissLocalDate1 = LocalDate.of(2023, 06, 29);
                LocalTime kissLocalTime1 = LocalTime.of(21, 30);
                LocalDateTime kissLocalDateTime1 = LocalDateTime.of(kissLocalDate1, kissLocalTime1);
                Gig kissGig1 = new Gig(kissLocalDateTime1, "IT", "Lucca", kiss, piazza_napoleone, null);

                LocalDate kissLocalDate2 = LocalDate.of(2023, 06, 19);
                LocalTime kissLocalTime2 = LocalTime.of(21, 00);
                LocalDateTime kissLocalDateTime2 = LocalDateTime.of(kissLocalDate2, kissLocalTime2);
                Gig kissGig2 = new Gig(kissLocalDateTime2, "PL", "Krakow", kiss, tauron_arena, null);

                List<Gig> kissGigs = new ArrayList<Gig>();
                kissGigs.addAll(Arrays.asList(kissGig1, kissGig2));
                gigService.createListOfGigs(kissGigs);
                
                // ++++++++++++++++++++++++++++++++++++++++++++++++++++

                // ---CREATING TICKETS---

                // METALLICA TICKETS
                Ticket metallicaTicket1 = new Ticket("MI400203YGT94HG9000", false, metallicaGig1, customer6);
                Ticket metallicaTicket2 = new Ticket("MI400203YGT94HG9102", false, metallicaGig1, customer10);
                Ticket metallicaTicket3 = new Ticket("MI400203YGT94HG9103", false, metallicaGig2, customer10);

                // KISS TICKETS
                Ticket kissTicket1 = new Ticket("MI500203YWXK94HG115", true, kissGig1, customer1);
                Ticket kissTicket2 = new Ticket("MI500203YWXK94HG116", true, kissGig1, customer4);
                Ticket kissTicket3 = new Ticket("AAAMITHOL923KJYR5078", false, kissGig2, customer13);

                // VASCO ROSSI TICKETS
                Ticket vascoRossiTicket1 = new Ticket("YYTR890WXK94HGUUOP", false, vascoRossiGig1, customer12);
                Ticket vascoRossiTicket2 = new Ticket("YYTR8903YWXK94UUOI", true, vascoRossiGig1, customer11);
                Ticket vascoRossiTicket3 = new Ticket("YYTR8903YWXK94URTY", true, vascoRossiGig1, customer14);
                Ticket vascoRossiTicket4 = new Ticket("YYTR8903YWXK94URTU", true, vascoRossiGig1, customer15);

                // IRON MAIDEN TICKETS
                Ticket ironMaidenTicket1 = new Ticket("XXXIUYB766GHJI09PP", true, ironMaidenGig1, customer3);
                Ticket ironMaidenTicket2 = new Ticket("XXXIUYB766GHJI09PX", true, ironMaidenGig1, customer4);
                Ticket ironMaidenTicket3 = new Ticket("XXXU6789766GHJI09OO", true, ironMaidenGig2, customer1);

                // BRUCE SPRINGSTEEN
                Ticket bruceSpringsteenTicket1 = new Ticket("DPOX87ERFML1123", true, bruceSpringsteenGig1, customer1);
                Ticket bruceSpringsteenTicket2 = new Ticket("Dfhi66ypoL42FF", false, bruceSpringsteenGig2, customer6);
                Ticket bruceSpringsteenTicket3 = new Ticket("Dfhi66ypoL42FY", false, bruceSpringsteenGig2, customer13);
                Ticket bruceSpringsteenTicket4 = new Ticket("Dfhi66ypoL556HY", true, bruceSpringsteenGig1, customer16);
                Ticket bruceSpringsteenTicket5 = new Ticket("Dfhi66ypoL786HU", true, bruceSpringsteenGig1, customer17);

                // DEEP PURPLE
                Ticket deepPurpleTicket1 = new Ticket("GMKWJGH8490OR66", true, deepPurpleGig1, customer2);
                Ticket deepPurpleTicket2 = new Ticket("GMKWJGH8490OR68", false, deepPurpleGig1, customer4);
                Ticket deepPurpleTicket3 = new Ticket("GMKWJGH836DHSW4", false, deepPurpleGig1, customer13);

                // GUNS ROSES
                Ticket gunsRosesTicket1 = new Ticket(" GH85NHFJHO7WJF4PP", false, gunsRosesGig1, customer1);
                Ticket gunsRosesTicket2 = new Ticket(" GH85NHF5687GFHRE4", false, gunsRosesGig1, customer8);
                Ticket gunsRosesTicket3 = new Ticket(" IK439T0GJHWE908U7", true, gunsRosesGig1, customer11);
                Ticket gunsRosesTicket4 = new Ticket(" IK439T0GJHWE908U8", true, gunsRosesGig1, customer15);
                Ticket gunsRosesTicket5 = new Ticket(" IK439T0GJHWE908U9", true, gunsRosesGig1, customer16);
                Ticket gunsRosesTicket6 = new Ticket(" EEEE87095867KJIPRTTJHG", false, gunsRosesGig2, customer6);
                Ticket gunsRosesTicket7 = new Ticket(" EEEE87095867KJIPRTTJ66", false, gunsRosesGig2, customer13);

                // CREATING A LIST OF TICKET

                List<Ticket> ticketList = new ArrayList<Ticket>();
                ticketList.addAll(Arrays.asList(metallicaTicket1, metallicaTicket2, metallicaTicket3, kissTicket1,
                                kissTicket2, kissTicket3, vascoRossiTicket1, vascoRossiTicket2, vascoRossiTicket3,
                                vascoRossiTicket4, ironMaidenTicket1, ironMaidenTicket2, ironMaidenTicket3,
                                bruceSpringsteenTicket1, bruceSpringsteenTicket2, bruceSpringsteenTicket3,
                                bruceSpringsteenTicket4, bruceSpringsteenTicket5, deepPurpleTicket1, deepPurpleTicket2,
                                deepPurpleTicket3, gunsRosesTicket1, gunsRosesTicket2, gunsRosesTicket3,
                                gunsRosesTicket4, gunsRosesTicket5, gunsRosesTicket6, gunsRosesTicket7));
                ticketService.createListOfTickets(ticketList);

                // ++++++++++++ DA COMPLETARSI +++++++++++++++++
        }
}
