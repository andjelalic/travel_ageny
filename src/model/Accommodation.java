package model;

import baza.Identifiable;

/**
 * Klasa koja predstavlja smještaj.
 */
public class Accommodation implements Identifiable {
    private int id;
    private int starReview;
    private String name;
    private String roomType;
    private double price;

    /**
     * Konstruktor za inicijalizaciju smještaja.
     * @param id         Identifikator smještaja.
     * @param starReview Broj zvjezdica za ocjenu smještaja.
     * @param name       Naziv smještaja.
     * @param roomType   Vrsta sobe.
     * @param price      Cijena po noćenju.
     */
    public Accommodation(int id, int starReview, String name, String roomType, double price) {
        this.id = id;
        this.starReview = starReview;
        this.name = name;
        this.roomType = roomType;
        this.price = price;
    }

    /**
     * Metoda koja vraća String reprezentaciju smještaja.
     * @return Tekstualni prikaz informacija o smještaju.
     */
    @Override
    public String toString() {
        return "[Smještaj] Naziv: " + name + ", Broj zvjezdica: " + starReview + ", Vrsta sobe: " + roomType + ", Cijena po noćenju: " + price;
    }

    /**
     * Metoda koja vraća identifikacioni broj smještaja.
     * @return Identifikator smještaja.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Metoda koja vraća broj zvjezdica za ocjenu smještaja.
     * @return Broj zvjezdica za ocjenu smještaja.
     */
    public int getStarReview() {
        return starReview;
    }

    /**
     * Metoda koja vraća naziv smještaja.
     * @return Naziv smještaja.
     */
    public String getName() {
        return name;
    }

    /**
     * Metoda koja vraća vrstu sobe smještaja.
     * @return Vrsta sobe.
     */
    public String getRoomType() {
        return roomType;
    }

    /**
     * Metoda koja vraća cijenu po noćenju smještaja.
     * @return Cijena po noćenju.
     */
    public double getPrice() {
        return price;
    }
}