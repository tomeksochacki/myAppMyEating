package pl.ts.model;

public class Wallet {
    private int id;
    private boolean isCash;

    public Wallet() {
    }

    public Wallet(int id, boolean isCash) {
        this.id = id;
        this.isCash = isCash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isCash() {
        return isCash;
    }

    public void setCash(boolean cash) {
        isCash = cash;
    }
}
