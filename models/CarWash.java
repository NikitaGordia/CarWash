package models;

import managers.CarGenerator;
import structures.CarStack;
import structures.observation.CTUObservable;
import structures.observation.CTUObserver;

public class CarWash {

    private CTUObservable[] timeLine;

    private int cycleCount;
    private int cycleInterval;
    private int deadline;

    private int carCountPerCycle;
    private int totalPrice;
    private int priceCity;
    private int priceTraveling;
    private int priceTravelingWithKids;

    private Worker[] workers = new Worker[] {
            new Worker("Nif-Nif"),
            new Worker("Noof-Noof"),
            new Worker("Nuf-Nuf")
    };

    private CarStack stack = new CarStack();

    public CarWash(int cycleCount, int cycleInterval) {
        this.cycleCount = cycleCount;
        this.cycleInterval = cycleInterval;
        deadline = cycleCount * cycleInterval;
        timeLine = new CTUObservable[deadline];
        for (int i = 0; i < deadline; i++) timeLine[i] = new CTUObservable();
    }

    public void perform() {
        init();

        for (int cycle = 0; cycle < cycleCount; cycle++) {
            System.out.println("New production cycle " + cycle + " starts");
            carCountPerCycle = priceCity = priceTraveling = priceTravelingWithKids = 0;
            for (int cycleTm = 0; cycleTm < cycleInterval; cycleTm++) {
                int tm = cycle * cycleInterval + cycleTm;
                timeLine[tm].act(tm, this);
            }
            System.out.println("Per production cycle " + cycle + " :");
            System.out.println("    Total cars : " + carCountPerCycle + ";");
            System.out.println("    Total price : " + totalPrice + ";");
            System.out.println("        City type price : " + priceCity + ";");
            System.out.println("        Traveling type price : " + priceTraveling + ";");
            System.out.println("        Traveling type price with kids : " + priceTravelingWithKids + ";");
        }
    }

    private void init() {
        for (int i = 0; i < workers.length; i++) pushObserver(0, workers[i]);
        pushObserver(0, new CarGenerator());
    }

    public void pushObserver(int tm, CTUObserver observer) {
        if (tm < deadline) timeLine[tm].push(observer);
    }

    public void readyCar(Car c) { stack.push(c); }

    public Car getReadyCar() { return stack.pop(); }

    public void carDone(Car c) {
        carCountPerCycle++;
        totalPrice += c.getPrice();
        if (c.getType() == 0) priceCity += c.getPrice();
        if (c.getType() == 1) priceTraveling += c.getPrice();
        if (c.getType() == 2) priceTravelingWithKids += c.getPrice();
    }
}
