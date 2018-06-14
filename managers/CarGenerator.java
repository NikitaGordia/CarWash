package managers;

import models.Car;
import models.CarWash;
import structures.observation.CTUObserver;

import java.util.Random;

public class CarGenerator implements CTUObserver {

    private final static int TIME_CITY = 30;
    private final static int TIME_TRAVELING = 40;
    private final static int TIME_TRAVELING_WITH_KIDS = 99;

    private final static int PRICE_CITY = 10;
    private final static int PRICE_TRAVELING = 15;
    private final static int PRICE_TRAVELING_WITH_KIDS = 40;

    private final static int CAR_SPAN_INTERVAL = 20;

    private Random r;
    private int carCounter;

    public CarGenerator() {
        r = new Random();
    }

    @Override
    public void stop(int tm, CarWash carWash) {
        Car c = generate();
        System.out.println("[" + tm + "] -> New car arrives on the carWash, #" + c.getNumber() + ", " + c.getType());
        carWash.readyCar(c);

    }

    @Override
    public void prepare(int tm, CarWash carWash) {}

    @Override
    public void start(int tm, CarWash carWash) {
        carWash.pushObserver(tm + CAR_SPAN_INTERVAL, this);
    }

    public Car generate() {
        int i = Math.abs(r.nextInt() % 3);
        if (i == 0) return new Car(i, carCounter++, TIME_CITY, PRICE_CITY);
        if (i == 1) return new Car(i, carCounter++, TIME_TRAVELING, PRICE_TRAVELING);
        if (i == 2) return new Car(i, carCounter++, TIME_TRAVELING_WITH_KIDS, PRICE_TRAVELING_WITH_KIDS);
        return null;
    }
}
