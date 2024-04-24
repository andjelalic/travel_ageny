package model;

/**
 * Enum koja predstavlja tipove rezervacija.
 */
public enum ReservationType {
    ACTIVE(1),
    PAST(2),
    CANCELED(3);

    private int op;

    /**
     * Konstruktor za enum ReservationType.
     * @param op Numerička vrijednost tipa rezervacije
     */
    private ReservationType(int op) {
        this.op = op;
    }

    /**
     * Metoda koja vraća odgovarajući ReservationType na osnovu datog broja.
     * @param i Broj koji predstavlja tip rezervacije
     * @return Odgovarajući ReservationType
     */
    public static ReservationType fromInt(int i) {
        switch (i) {
            case 1: return ACTIVE;
            case 2: return PAST;
            case 3: return CANCELED;
            default: return null;
        }
    }
}