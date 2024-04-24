package model;

/**
 * Apstraktna klasa koja predstavlja korisnika sistema.
 */
public abstract class User {
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;

    /**
     * Konstruktor za inicijalizaciju korisnika.
     * @param id        Identifikacioni broj korisnika.
     * @param firstName Ime korisnika.
     * @param lastName  Prezime korisnika.
     * @param username  Korisničko ime korisnika.
     * @param password  Lozinka korisnika.
     */
    public User(int id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    /**
     * Metoda koja vraća identifikacioni broj korisnika.
     * @return Identifikacioni broj korisnika.
     */
    public int getId() {
        return id;
    }

    /**
     * Metoda koja vraća ime korisnika.
     * @return Ime korisnika.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Metoda koja vraća prezime korisnika.
     * @return Prezime korisnika.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Metoda koja vraća korisničko ime korisnika.
     * @return Korisničko ime korisnika.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metoda koja vraća lozinku korisnika.
     * @return Lozinka korisnika.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Metoda koja postavlja lozinku korisnika.
     * @param password Nova lozinka korisnika.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metoda koja vraća string reprezentaciju korisnika.
     * @return String reprezentacija korisnika.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " Korisničko ime: " + username;
    }

    /**
     * Metoda koja proverava da li korisničko ime odgovara datom stringu.
     * @param s String koji se upoređuje sa korisničkim imenom.
     * @return True ako se string podudara sa korisničkim imenom, inače false.
     */
    public boolean usernameMatch(String s) {
        return username.equals(s);
    }

    /**
     * Metoda koja proverava da li lozinka odgovara datom stringu.
     * @param s String koji se upoređuje sa lozinkom.
     * @return True ako se string podudara sa lozinkom, inače false.
     */
    public boolean passwordMatch(String s) {
        return password.equals(s);
    }

    /**
     * Metoda koja proverava da li korisničko ime i lozinka odgovaraju datim stringovima.
     * @param s1 Korisničko ime koje se upoređuje.
     * @param s2 Lozinka koja se upoređuje.
     * @return True ako se korisničko ime i lozinka podudaraju, inače false.
     */
    public boolean usernamePasswordMatch(String s1, String s2) {
        return usernameMatch(s1) && passwordMatch(s2);
    }
}