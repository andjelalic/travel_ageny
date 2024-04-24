package agencija;

public class Korisnik {
    protected int id;
    protected String ime;
    protected String prezime;
    protected String korisnickoIme;
    protected String lozinka;
    public Korisnik(int id, String ime, String prezime, String korisnickoIme, String lozinka){
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getId() {
        return id;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public String getIme() {
        return ime;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public boolean provjeraKimena(String s) {
        return this.korisnickoIme.equals(s);
    }

    public boolean provjeraLozinke(String s) {
        return this.korisnickoIme.equals(s);
    }

    public boolean provjeraPodatakaZaPrijavu(String s1, String s2) {
        return this.provjeraLozinke(s1) && this.provjeraKimena(s2);
    }
    public String toString() {
        return "Ime: " + this.ime + " Prezime: " + this.prezime + " Korisničko ime: " + korisnickoIme;
    }
}
