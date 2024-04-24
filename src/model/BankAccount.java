package model;

/**
 * Klasa koja predstavlja bankovni račun.
 */
public class BankAccount {
    private int id;
    private String jmbg;
    private String accNumber;
    private double balance;

    /**
     * Konstruktor za inicijalizaciju bankovnog računa.
     *
     * @param id         Identifikacioni broj bankovnog računa.
     * @param jmbg       JMBG koji se podudara sa klijentom ili agencijom.
     * @param accNumber  Broj bankovnog računa.
     * @param balance    Trenutno stanje na računu.
     */
    public BankAccount(int id, String jmbg, String accNumber, double balance) {
        this.id = id;
        this.jmbg = jmbg;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    /**
     * Metoda koja vraća identifikacioni broj bankovnog računa.
     * @return Identifikacioni broj bankovnog računa.
     */
    public int getId() {
        return id;
    }

    /**
     * Metoda za dobijanje JMBG.
     * @return JMBG ili identifikator agencije.
     */
    public String getJmbg() {
        return jmbg;
    }

    /**
     * Metoda koja vraća broj bankovnog računa.
     * @return Broj bankovnog računa.
     */
    public String getAccNumber() {
        return accNumber;
    }

    /**
     * Metoda koja vraća trenutno stanje na računu.
     * @return Trenutno stanje na računu.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Metoda za postavljanje trenutnog stanja na računu.
     * @param balance Novo stanje na računu.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Metoda koja proverava da li je uneti broj bankovnog računa jednak broju računa ovog bankovnog računa.
     * @param s Broj bankovnog računa za proveru.
     * @return True ako su brojevi računa jednaki, inače False.
     */
    public boolean accNumberCheck(String s) {
        return accNumber.equals(s);
    }

    /**
     * Metoda koja proverava da li je uneti JMBG jednak JMBG-u koji se podudara sa klijentom.
     * @param s JMBG za proveru.
     * @return True ako su JMBG jednaki, inače False.
     */
    public boolean jmbgCheck(String s) {
        return jmbg.equals(s);
    }

    /**
     * Metoda koja proverava da li je bankovni račun pripada agenciji.
     * Agencijski bankovni računi imaju JMBG dužine 10 karaktera.
     * @return True ako je bankovni račun agencijski, inače False.
     */
    public boolean isAgencyBankAccount() {
        return jmbg.length() == 10;
    }
}