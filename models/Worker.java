package models;

import structures.observation.CTUObserver;

public class Worker implements CTUObserver {

    private String name;
    private int working;
    private int waiting;
    private Car currentCar;

    Worker(String name) {
        this.name = name;
    }

    @Override
    public void stop(int tm, CarWash carWash) {
        if (currentCar != null && tm - working == currentCar.getWashTime()) {
            waiting = tm;
            carWash.carDone(currentCar);
            System.out.println("[" + tm + "] -> Worker " + name + " washed a car #" + currentCar.getNumber() + ", " + currentCar.getType() + ", spent " + currentCar.getWashTime() + " CTU on washing, got " + currentCar.getPrice() + "$");
            currentCar = null;
        }
    }

    @Override
    public void prepare(int tm, CarWash carWash) {
        if (currentCar == null) {
            currentCar = carWash.getReadyCar();
            if (currentCar != null) {
                working = tm;
                currentCar.setWaitingFrom(-1); //Car chosen
                carWash.pushObserver(tm + currentCar.getWashTime(), this); //Check for release car
                System.out.println("[" + tm + "] -> Worker " + name + " starts wash new car #" + currentCar.getNumber() + ", " + currentCar.getType());
            }
        }
    }

    @Override
    public void start(int tm, CarWash carWash) {
        if (currentCar == null) {
            System.out.println("[" + tm + "] -> Worker " + name + " has had production downtime " + (tm - waiting + 1) + " CTU");
            carWash.pushObserver(tm + 1, this);
        }
    }
}
