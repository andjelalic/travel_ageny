package agencija;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Aranzman {
    private int id;

    private Smjestaj smjestaj;
    private String naziv_putovanja;
    private String destinacija;
    private String prevoz;
    private LocalDate datum_polaska;
    private LocalDate datum_dolaska;
    private double cijena_aranzmana;
    public Aranzman(int id , Smjestaj smjestaj, String naziv_putovanja, String destinacija, String prevoz,LocalDate datum_polaska, LocalDate datum_dolaska, double cijena_aranzmana){
        this.id = id;
        this.smjestaj = smjestaj;
        this.naziv_putovanja = naziv_putovanja;
        this.destinacija= destinacija;
        this.prevoz = prevoz;
        this.datum_polaska = datum_polaska;
        this.datum_dolaska = datum_dolaska;
        this.cijena_aranzmana = cijena_aranzmana;
    }

    public int getId() {
        return id;
    }

    public Smjestaj getSmjestaj() {
        return smjestaj;
    }

    public double getCijena_aranzmana() {
        return cijena_aranzmana;
    }

    public LocalDate getDatum_dolaska() {
        return datum_dolaska;
    }

    public LocalDate getDatum_polaska() {
        return datum_polaska;
    }

    public String getDestinacija() {
        return destinacija;
    }

    public String getNaziv_putovanja() {
        return naziv_putovanja;
    }

    public String getPrevoz() {
        return prevoz;
    }

    public int vrijemeDoPolaska(){
        return (int) ChronoUnit.DAYS.between(LocalDate.now(), this.datum_dolaska);
    }
    public boolean jeJednodnevni() {
            return this.smjestaj == null && this.datum_polaska==this.datum_dolaska;
    }
}
