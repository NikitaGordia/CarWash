package models;

import structures.observation.CTUObserver;

public class Car extends CTUObserver {

    private final static int CAR_WAITING_LIMIT = 60;

    private int washTime;
    private int price;
    private int number;
    private int type;

    private int waitingFrom;

    public Car(int type, int number, int washTime, int price) {
        this.washTime = washTime;
        this.price = price;
        this.number = number;
        this.type = type;
    }

    @Override
    protected void stop(int tm, CarWash carWash) {}

    @Override
    protected void prepare(int tm, CarWash carWash) {}

    @Override
    protected void start(int tm, CarWash carWash) {
        if (waitingFrom == -1) return; //Car is washing or have already washed
        if (waitingFrom == 0) { //Start waiting timer
            waitingFrom = tm;
            carWash.pushObserver(waitingFrom + CAR_WAITING_LIMIT, this);
        }
        if (tm - waitingFrom > CAR_WAITING_LIMIT) System.out.println("[" + tm + "] ->  Car " + number + ", " + type + " waited for washing more than " + CAR_WAITING_LIMIT + " CTU");
    }

    public int getWaitingFrom() {
        return waitingFrom;
    }

    public void setWaitingFrom(int waitingFrom) {
        this.waitingFrom = waitingFrom;
    }

    public int getWashTime() {
        return washTime;
    }

    public int getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public int getType() {
        return type;
    }
}
