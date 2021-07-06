package pl.ts.model;

public class Dish {
    private int id;
    private Taste taste;
    private Status status;
    private Restaurant restaurant;
    private PriceRange priceRange;

    public Dish() {
    }

    public Dish(int id, Taste taste, Status status, Restaurant restaurant, PriceRange priceRange) {
        this.id = id;
        this.taste = taste;
        this.status = status;
        this.restaurant = restaurant;
        this.priceRange = priceRange;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public PriceRange getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(PriceRange priceRange) {
        this.priceRange = priceRange;
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