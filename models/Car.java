package models;

import structures.observation.CTUObserver;

public class Car implements CTUObserver {

    private final static int CAR_WAITING_LIMIT = 60;

    private int washTime;
    private int price;
    private int number;
    private int type;

    private int waitingTo;

    public Car(int type, int number, int washTime, int price) {
        this.washTime = washTime;
        this.price = price;
        this.number = number;
        this.type = type;
    }

    @Override
    public void stop(int tm, CarWash carWash) {}

    @Override
    public void prepare(int tm, CarWash carWash) {}

    @Override
    public void start(int tm, CarWash carWash) {
        if (waitingTo == -1) return; //Car is washing or have already washed
        if (waitingTo == 0) { //Start waiting timer
            waitingTo = tm + CAR_WAITING_LIMIT;
            carWash.pushObserver(waitingTo, this);
        } else {
            if (waitingTo >= tm)
                System.out.println("[" + tm + "] -> Car " + number + ", " + type + " waited for washing more than " + CAR_WAITING_LIMIT + " CTU");

        }
    }

    public void setWaitingTo(int waitingTo) {
        this.waitingTo = waitingTo;
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
