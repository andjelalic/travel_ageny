package agencija;

public class BankovniRacun {
    private int id;
    private String jmbg;
    private String brojRacuna;
    private  double stanjeRacuna;
    public BankovniRacun(int id, String jmbg, String brojRacuna, double stanjeRacuna){
        this.id = id;
        this.jmbg = jmbg;
        this.brojRacuna = brojRacuna;
        this.stanjeRacuna = stanjeRacuna;
    }

    public int getId() {
        return id;
    }

    public String getJmbg() {
        return jmbg;
    }

    public String getBrojRacuna() {
        return brojRacuna;
    }

    public double getStanjeRacuna() {
        return stanjeRacuna;
    }

    public void setStanje_racuna(double stanjeRacuna) {
        this.stanjeRacuna = stanjeRacuna;
    }

    public boolean provjera_jmbg(String s){
        return this.jmbg.equals(s);
    }
    public boolean provjera_broja(String s){
        return  this.brojRacuna.equals(s);
    }
}
