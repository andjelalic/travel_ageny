package agencija;

public class Rezervacije {
    private int klijentId;
    private String aranzmanId;
    private String ukupnaCijena;
    private String placenaCijena;
    public Rezervacije(int klijentId, String aranzmanId, String ukupnaCijena, String placenaCijena){
        this.klijentId = klijentId;
        this.aranzmanId = aranzmanId;
        this.ukupnaCijena = ukupnaCijena;
        this.placenaCijena = placenaCijena;
    }
}
