package agencija;

public class Klijent extends  Korisnik{
    private String jmbg;
    private String brojTelefona;

    public  Klijent(int id, String ime, String prezime, String korisnickoIme, String lozinka, String jmbg, String brojTelefona){
        super(id, ime, prezime, korisnickoIme, lozinka);
        this.brojTelefona = brojTelefona;
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }
}
