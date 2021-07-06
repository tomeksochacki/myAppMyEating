package pl.ts.model;

public class Address {
    private int id;
    private int numberLocal;
    private int numberHouse;
    private String street;
    private String district;
    private String place;

    public Address() {
    }

    public Address(int id, int numberLocal, int numberHouse, String street, String district, String place) {
        this.id = id;
        this.numberLocal = numberLocal;
        this.numberHouse = numberHouse;
        this.street = street;
        this.district = district;
        this.place = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberLocal() {
        return numberLocal;
    }

    public void setNumberLocal(int numberLocal) {
        this.numberLocal = numberLocal;
    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
