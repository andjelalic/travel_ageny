package model;

/**
 * Klasa koja predstavlja administratora aplikacije.
 * Nasleđuje osnovne karakteristike i funkcionalnosti korisnika iz klase User.
 */
public class Admin extends User {
    /**
     * Konstruktor za inicijalizaciju admina.
     * @param id        Identifikacioni broj admina.
     * @param firstName Ime admina.
     * @param lastName  Prezime admina.
     * @param username  Korisničko ime admina.
     * @param password  Lozinka admina.
     */
    public Admin(int id, String firstName, String lastName, String username, String password) {
        super(id, firstName, lastName, username, password);
    }

    /**
     * Metoda koja proverava da li je lozinka admina "12345678".
     * @return True ako je lozinka "12345678", inače false.
     */
    public boolean isDefaultPassword() {
        return password.equals("12345678");
    }
}
