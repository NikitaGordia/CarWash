package models;

public class Car {

    private int washTime;
    private int price;

    public Car(int washTime, int price) {
        this.washTime = washTime;
        this.price = price;
    }

    public int getWashTime() {
        return washTime;
    }

    public void setWashTime(int washTime) {
        this.washTime = washTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
