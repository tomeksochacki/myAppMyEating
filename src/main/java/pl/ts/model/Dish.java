package pl.ts.model;

public class Dish {
    private int id;
    private Taste taste;

    public Dish() {
    }

    public Dish(int id, Taste taste) {
        this.id = id;
        this.taste = taste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Taste getTaste() {
        return taste;
    }

    public void setTaste(Taste taste) {
        this.taste = taste;
    }

    public enum Taste {
        SALTY,
        SWEET;
    }

    public enum Status {
        ACCEPTED, //przyjęte
        GOES_TO_YOU, //jedzie do ciebie
        NOT_ACCEPTED; //nieprzyjęte
    }

    //TODO JAK ZAPISAĆ POPRAWNIE NAZWE TEGO ENUMA - DWA WYRAZY Z DUŻEJ LITERY??
    public enum PriceRange {
        UP_TO_20_PLN,
        UP_TO_40_PLN,
        UP_TO_60_PLN,
        UP_TO_80_PLN,
        UP_TO_100_PLN;

    }
}