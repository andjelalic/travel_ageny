package model;

/**
 * Klasa koja predstavlja rezervaziju za aranžman.
 */
public class Reservation {
    private Client client;
    private Arrangement arrangement;
    private ReservationType reservationType;
    private double paidAmount;
    private double totalPrice;

    /**
     * Konstruktor za inicijalizaciju rezervacije.
     * @param client           Klijent
     * @param arrangement      Aranžman
     * @param reservationType  Tip rezervacije
     * @param paidAmount       Plaćena cijena
     * @param totalPrice       Ukupna cijena
     */
    public Reservation(Client client, Arrangement arrangement, ReservationType reservationType, double paidAmount, double totalPrice) {
        this.client = client;
        this.arrangement = arrangement;
        this.reservationType = reservationType;
        this.paidAmount = paidAmount;
        this.totalPrice = totalPrice;
    }

    /**
     * Metoda koja vraća klijenta.
     * @return Klijent
     */
    public Client getClient() {
        return client;
    }

    /**
     * Metoda koja vraća aranžman koji se rezerviše.
     * @return Rezervisani aranžman
     */
    public Arrangement getArrangement() {
        return arrangement;
    }

    /**
     * Metoda koja vraća tip rezervacije.
     * @return Tip rezervacije
     */
    public ReservationType getReservationType() {
        return reservationType;
    }

    /**
     * Metoda koja vraća iznos koji je klijent do sad uplatio.
     * @return Uplaćeni iznos
     */
    public double getPaidAmount() {
        return paidAmount;
    }

    /**
     * Metoda koja vraća ukupnu cijenu.
     * @return Ukupna cijena
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Metoda koja postavlja tip rezervacije.
     * @param reservationType Tip rezervacije
     */
    public void setReservationType(ReservationType reservationType) {
        this.reservationType = reservationType;
    }

    /**
     * Metoda koja ažurira uplaćenu cijenu.
     * @param paidAmount Nova uplaćena cijena
     */
    public void setPaidAmount(double paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * Metoda koja vraća stringovnu reprezentaciju rezervacije
     * @return Stringovna reprezentacija rezervacije
     */
    @Override
    public String toString() {
        return client.getUsername() + " " + arrangement.getName() + " Ukupna cijena: " +  arrangement.fullPrice();
    }

    /**
     * Metoda koja provjerava da li je rezervacija u potpunosti plaćena.
     * @return True ako je u potpunosti plaćena, inače False
     */
    public boolean isPaidInTotal() {
        return paidAmount == totalPrice;
    }


    /**
     * Metoda koja provjerava da li je rezervacija protekla.
     * Rezervacija je protekla ako je klijent u potpunosti plaito rezervaciju,
     * i ako je došao/prošao dan polaska.
     * @return True ako je rezervacija protekla, False inače.
     */
    public boolean isPastReservation() {
        return isPaidInTotal() && !arrangement.isTripOnOffer();
    }

    /**
     * Metoda koja provjerava da li je rezervacija otkazana.
     * Rezervacija je otkazana ako je sam klijent otkazao rezervaciju,
     * ili ako je prošao rok za plaćanje i klijent nije u potpunosti platio rezervaciju.
     * @return True ako je rezervacija otkazana, False inače.
     */
    public boolean isCanceledReservation() {
        return isCanceledByClient() || (!isPaidInTotal() && arrangement.isPastDeadline());
    }

    /**
     * Metoda koja poredi tip rezervacije da vidi da li je aktivna.
     * @return True ako jeste aktivna, False inače.
     */
    public boolean isActiveReservation() {
        return reservationType == ReservationType.ACTIVE;
    }

    /**
     * Metoda koja računa koliko je klijent još treba da uplati novca.
     * @return Preostali iznos za uplatu
     */
    public double leftToPay() {
        return totalPrice - paidAmount;
    }

    /**
     * Metoda koja provjerava da li je ističe rok za uplatu.
     * Provjerava se da li je ostalo tri dana do polaska na put, i da li je rezervacija plaćena.
     * @return True ako ističe rok, False inače.
     */
    public boolean threeDaysLeft() {
        return arrangement.isInDeadline() && !isPaidInTotal();
    }

    /**
     * Metoda koja provjerava da li klijent može da otkaže rezervaciju.
     * Može da otkaže ako još nije prošao rok za uplatu i ako je rezervacija aktivna.
     * @return True ako može otkazati rezervaciju, False inače.
     */
    public boolean isCancellationAvailable() {
        return arrangement.daysUntilTrip() >= Arrangement.PAYMENT_DEADLINE_END && isActiveReservation();
    }

    /**
     * Metoda koja provjerava da li je klijent otkazao rezervaciju.
     * Klijent je otkazao rezervaciju ako je sav novac koji je uplatio vraćen.
     * @return True ako je rezervacija otkazana od strane klijenta, False inače.
     */
    public boolean isCanceledByClient() {
        return paidAmount == 0;
    }

    /**
     * Metoda koja provjerava da li se određeni aranžman poklapa sa aranžmanom rezervacije.
     * @param a Aranžman za provjeru
     * @return True ako se poklapa, False inače
     */
    public boolean arrangementMatch(Arrangement a) {
        return arrangement.getId() == a.getId();
    }

    /**
     * Metoda koja provjerava dali se određeni klijent poklapa sa klijentom rezervacije.
     * @param c Klijent za provjeru
     * @return True ako se poklapa, False inače.
     */
    public boolean clientMatch(Client c) {
        return client.getId() == c.getId();
    }

    /**
     * Metoda koja provjerava da li je rezervacija već rezervisana.
     * Rezervacija je već rezervisana ako se poklapaju i klijent i aranžman.
     * @param c Klijent za provjeru
     * @param arr Aranžman za provjeru
     * @return True ako je rezervacija već rezervisana, False inače.
     */
    public boolean isAlreadyReserved(Client c, Arrangement arr) {
        return clientMatch(c) && arrangementMatch(arr);
    }

    /**
     * Metoda koja provjerava da li se klijent i tip rezervacije poklapaju sa određenim klijentom i tipom.
     * @param id Identifikator klijenta
     * @param rt Tip rezervacije
     * @return True ako se poklapaju, False inače.
     */
    public boolean getReservationByClientIdAndType(int id, ReservationType rt) {
        return client.getId() == id && reservationType == rt;
    }

    /**
     * Metoda koja provjerava da li se klijent mora obavjestiti za rok plaćanja rezervacije.
     * Klijent se mora obavjestiti ako je rezervacija aktivna i ako je ostalo tri dana za uplatu.
     * @param id Identifikator klijenta
     * @return True ako se mora obavjestiti, False inače.
     */
    public boolean needToBeAlerted(int id) {
        return client.getId() == id && threeDaysLeft() && isActiveReservation();
    }

    /**
     * Metoda koja provjerava da li se za ovu rezervaciju mora vratiti novac, kada admin otkaže rezervaciju.
     * Novac se vraća ako se poklapa aranžman koji se otkazuje i ako je rezervacija aktivna.
     * @param arr Aranžman koji se otkazuje
     * @return True ako treba vratiti novac, False inače.
     */
    public boolean checkForRefund(Arrangement arr) {
        return arrangementMatch(arr) && !isCanceledReservation();
    }
}