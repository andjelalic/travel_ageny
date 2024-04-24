package model;

/**
 * Klasa koja predstavlja klijenta agencije.
 * Nasleđuje osnovne karakteristike i funkcionalnosti korisnika iz klase User.
 */
public class Client extends User {
    private String phoneNumber;
    private String jmbg;
    private String bankAccNumber;

    /**
     * Konstruktor za inicijalizaciju klijenta.
     * @param id            Identifikacioni broj klijenta.
     * @param firstName     Ime klijenta.
     * @param lastName      Prezime klijenta.
     * @param username      Korisničko ime klijenta.
     * @param password      Lozinka klijenta.
     * @param phoneNumber   Broj telefona klijenta.
     * @param jmbg          JMBG klijenta.
     * @param bankAccNumber Broj bankovnog računa klijenta.
     */
    public Client(int id, String firstName, String lastName, String username, String password, String phoneNumber, String jmbg, String bankAccNumber) {
        super(id, firstName, lastName, username, password);
        this.phoneNumber = phoneNumber;
        this.jmbg = jmbg;
        this.bankAccNumber = bankAccNumber;
    }

    /**
     * Metoda koja vraća broja telefona klijenta.
     * @return Broj telefona klijenta.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Metoda koja vraća JMBG klijenta.
     * @return JMBG klijenta.
     */
    public String getJmbg() {
        return jmbg;
    }

    /**
     * Metoda koja vraća broja bankovnog računa klijenta.
     * @return Broj bankovnog računa klijenta.
     */
    public String getBankAccNumber() {
        return bankAccNumber;
    }
}