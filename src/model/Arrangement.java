package model;

import baza.Identifiable;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

/**
 * Klasa koja predstavlja aranžman.
 */
public class Arrangement implements Identifiable {
    private int id;
    private String name;
    private String destination;
    private String transport;
    private LocalDate tripDate;
    private LocalDate arrivalDate;
    private double price;
    private Accommodation accommodation;

    // Konstante za rok uplate
    public final static int PAYMENT_DEADLINE_START = 16;
    public final static int PAYMENT_DEADLINE_END = 14;

    // Komparatori za poređenje
    public final static Comparator<Arrangement> compareID = (o1, o2) -> Integer.compare(o1.id, o2.id);
    public final static Comparator<Arrangement> comparePrice = (o1, o2) -> Double.compare(o1.fullPrice(), o2.fullPrice());
    public final static Comparator<Arrangement> compareTripDate = (o1, o2) -> o1.getTripDate().compareTo(o2.getTripDate());

    /**
     * Konstruktor za inicijalizaciju aranžmana.
     * @param id              Identifikator aranžmana
     * @param name            Naziv putovanja
     * @param destination     Destinacija
     * @param transport       Tip prevoza
     * @param tripDate        Datum polaska
     * @param arrivalDate     Datum dolaska
     * @param price           Cijena aranžmana
     * @param accommodation   Smještaj
     */
    public Arrangement(int id, String name, String destination, String transport, LocalDate tripDate, LocalDate arrivalDate, double price, Accommodation accommodation) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.transport = transport;
        this.tripDate = tripDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
        this.accommodation = accommodation;
    }

    /**
     * Statička metoda koja vraća kolika je razlika između dva datuma.
     * @param date1 Prvi datum
     * @param date2 Drugi datum
     * @return Razlika u broju dana
     */
    public static int dateDifference(LocalDate date1, LocalDate date2) {
        return (int) ChronoUnit.DAYS.between(date1, date2);
    }

    /**
     * Metoda koja provjerava da li se destinacija aranžmana poklapa sa određenom destinacijom.
     * @param s Destinacija za provjeru
     * @return True ako se poklapa, False inače
     */
    public boolean destinationMatch(String s) {
        return destination.equals(s);
    }

    /**
     * Metoda koja provjerava da li se tip prevoza aranžmana poklapa sa određenom tipom prevoza.
     * @param s Tip prevoza za provjeru
     * @return True ako se poklapa, False inače
     */
    public boolean transportMatch(String s) {
        return transport.equals(s);
    }

    /**
     * Metoda koja provjerava da li je ukupna cijena manja ili jednako sa određenim iznosom.
     * @param amount Iznos koji se provjerava
     * @return True ako je manje-jednaka, False inače
     */
    public boolean isLessEqualThanAmount(Double amount) {
        return fullPrice() <= amount;
    }

    /**
     * Metoda koja provjerava da li je datum polaska aranžmana poslije određenog datuma.
     * @param date Datum koji se provjerava
     * @return True ako jeste, False inače
     */
    public boolean isTripScheduledAfter(LocalDate date) {
        return !tripDate.isBefore(date);
    }

    /**
     * Metoda koja provjerava da li je datum dolaska prije određenog datuma.
     * @param date Datum koji se provjerava
     * @return True ako jeste, False inače
     */
    public boolean isArrivalPlanedBefore(LocalDate date) {
        return !arrivalDate.isAfter(date);
    }

    /**
     * Metoda koja provjerava da li je aranžman u ponudi.
     * @return True ako je u ponudi, False inače.
     */
    public boolean isTripOnOffer() {
        return tripDate.isAfter(LocalDate.now());
    }

    /**
     * Metoda koja vraća identifikator aranžmana.
     * @return Identifikator aranžmana.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Metoda koja vraća naziv putovanja.
     * @return Naziv putovanja
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda koja vraća destinaciju.
     * @return Destinacija
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Metoda koja vraća tip prevoza.
     * @return Tip prevoza
     */
    public String getTransport() {
        return transport;
    }

    /**
     * Metoda koja vraća datum polaska.
     * @return Datum polaska
     */
    public LocalDate getTripDate() {
        return tripDate;
    }

    /**
     * Metoda koja vrača datum dolaska.
     * @return Datum dolaska
     */
    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    /**
     * Metoda koja vraća cijenu aranžmana
     * @return Cijena aranžmana
     */
    public double getPrice() {
        return price;
    }

    /**
     * Metoda koja vraća smještaj.
     * @return Smještaj
     */
    public Accommodation getAccommodation() {
        return accommodation;
    }

    /**
     * Metoda koja vraća broj noćenja.
     * @return Broj noćenja.
     */
    private int getNumberOfNights() {
        return dateDifference(tripDate, arrivalDate) - 1;
    }

    /**
     * Metoda koja računa punu cijenu aranžmana.
     * Ako je aranžman putovanje računamo cijenu aranžmana + (broj noćenja * cijena smještaja po noćenju),
     * inače samo cijenu aranžmana.
     * @return Puna cijena putovanja-
     */
    public double fullPrice() {
        return accommodation == null ? price : price + (getNumberOfNights() * accommodation.getPrice());
    }

    /**
     * Meotda koja vraća 50% cijene aranžmana.
     * @return 50% cijene
     */
    public double getHalfPrice() {
        return fullPrice() / 2;
    }

    /**
     * Metoda koja vraća stringovnu reprezentaciju aranžmana.
     * @return Stringovna reprezentacija aranžmana.
     */
    @Override
    public String toString() {
        if (accommodation != null)
            return name + " Destinacija: " + destination + " Prevoz: " + transport + " Polazak: " + tripDate + " Dolazak: " + arrivalDate + " Cijena: " + price + " " + accommodation;
        else
            return name + " Destinacija: " + destination + " Prevoz: " + transport + " Polazak: " + tripDate + " Dolazak: " + arrivalDate + " Cijena: " + price;
    }


    /**
     * Metoda koja vraća koliki je iznos za uplatu.
     * Ako je prošao rok za uplatu, klijent koji želi da rezerviše ovaj aranžman,
     * mora da plati punu cijenu, inače se plaća 50% cijene.
     * @return Iznos za uplatu aranžmana
     */
    public double getAmountForPayment() {
        return isPastDeadline() ? fullPrice() : getHalfPrice();
    }

    /**
     * Metoda koja vraća da li je prošao rok za uplatu.
     * @return True ako jeste prošao rok, False inače.
     */
    public boolean isPastDeadline() {
        return daysUntilTrip() < PAYMENT_DEADLINE_END;
    }

    /**
     * Metoda koja računa koliko je još dana ostalo do polaska na put.
     * @return Broj dana do polaska
     */
    public int daysUntilTrip() {
        return dateDifference(LocalDate.now(), tripDate);
    }

    /**
     * Metoda koja provjerava da li je ostalo 3 dana do polaska,
     * da bi se klijenti za koji su rezervisali taj aranžman mogli obavjestiti.
     * @return True ako je ostalo 3 dana, False inače.
     */
    public boolean isInDeadline() {
        return daysUntilTrip() >= PAYMENT_DEADLINE_END && daysUntilTrip() <= PAYMENT_DEADLINE_START;
    }
}