package model;

import baza.BazaKonekcija;

import java.sql.SQLException;
import java.util.List;

/**
 * Klasa koja predstavlja agenciju.
 */
public class Agency {
    protected List<User> users;
    protected List<Arrangement> arrangements;
    protected List<Accommodation> accommodations;
    protected List<BankAccount> bankAccounts;
    protected List<Reservation> reservations;
    protected BankAccount agencyBankAccount;

    // Poruka za grešku u bazi podataka
    public final static String BazaKonekcija_ERROR_MESSAGE = "Greška u bazi podataka!";

    /**
     * Konstruktor klase Agency koji inicijalizuje agenciju.
     * @throws SQLException Izuzetak koji se baca u slučaju greške pri pristupu bazi podataka
     */
    public Agency() throws SQLException {
        // Inicijalizacija liste korisnika, aranžmana, smještaja, bankovnih računa, rezervacija i bankovnog računa agencije iz baze podataka
        users = BazaKonekcija.getUsers();
        arrangements = BazaKonekcija.getArrangements();
        accommodations = BazaKonekcija.getAccommodations();
        bankAccounts = BazaKonekcija.getBankAccounts();
        reservations = BazaKonekcija.getReservations();
        agencyBankAccount = BazaKonekcija.getAgencyBankAccount();
    }

    /**
     * Metoda koja vraća listu aranžmana.
     * @return Lista aranžmana
     */
    public List<Arrangement> getArrangements() {
        arrangements.sort(Arrangement.compareID);
        return arrangements;
    }

    /**
     * Metoda koja vraća listu korisnika.
     * @return Lista korisnika
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     * Metoda koja vraća listu rezervacija.
     * @return Lista rezervacija
     */
    public List<Reservation> getReservations() {
        return reservations;
    }

    /**
     * Metoda koja vraća listu smještaja.
     * @return Lista smještaja
     */
    public List<Accommodation> getAccommodations() {
        return accommodations;
    }

    /**
     * Metoda koja vraća listu bankovnih računa.
     * @return Lista bankovnih računa
     */
    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    /**
     * Metoda koja vraća bankovni račun agencije.
     * @return Bankovni račun agencije
     */
    public BankAccount getAgencyBankAccount() {
        return agencyBankAccount;
    }
}