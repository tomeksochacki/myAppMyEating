package pl.ts.model;

import java.time.LocalDateTime;


public class Order {
    private int id;
    private Taste taste;
    private Status status;
    private Address address;
    private User user;
    private PriceRange priceRange;
    private LocalDateTime localDateTime;


    public Order() {
    }

    public Order(int id, Taste taste, Status status, Address address, User user, PriceRange priceRange) {
        this.id = id;
        this.taste = taste;
        this.status = status;
        this.address = address;
        this.user = user;
        this.priceRange = priceRange;
        this.localDateTime = localDateTime.now();
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public enum PriceRange {
        UP_TO_20_PLN,
        UP_TO_40_PLN,
        UP_TO_60_PLN,
        UP_TO_80_PLN,
        UP_TO_100_PLN;
    }
}
