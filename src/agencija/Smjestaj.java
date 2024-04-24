package agencija;

public class Smjestaj {
    private String naziv;
    private String broj_zvjezdica;
    private String vrsta_sobe;
    private  double cijena_po_nocenju;
    private int id;

    public Smjestaj(String naziv, String broj_zvjezdica, String vrsta_sobe, double cijena_po_nocenju, int id){
        this.naziv = naziv;
        this.broj_zvjezdica = broj_zvjezdica;
        this.vrsta_sobe = vrsta_sobe;
        this.cijena_po_nocenju = cijena_po_nocenju;
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getBroj_zvjezdica() {
        return broj_zvjezdica;
    }

    public double getCijena_po_nocenju() {
        return cijena_po_nocenju;
    }

    public String getVrsta_sobe() {
        return vrsta_sobe;
    }
}
