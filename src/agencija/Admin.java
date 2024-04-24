package agencija;

public class Admin extends Korisnik{

        public Admin(int id, String ime, String prezime, String korisnickoIme, String lozinka){
            super(id, ime, prezime, korisnickoIme, lozinka);
        }

        public boolean jePodrazumevanaLozinka() {
        return this.lozinka.equals("12345678");
    }


}
