package pl.ts.model;

public class User {
    private int id;
    private String name;
    private Address address;
    private String phoneNumber;
    private Wallet wallet; //TODO JAK ZROBIĆ PŁATNOŚĆ PRZELEWEM, KARTĄ ITP.

    public User() {
    }

    public User(int id, String name, Address address, String phoneNumber, Wallet wallet) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.wallet = wallet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }
}
