package structures;

import models.Car;

public class CarStack {

    private CarNode first;
    private int size;

    public void push(Car car) {
        CarNode nd = new CarNode(car);
        size++;
        if (first == null) {
            first = nd;
        } else {
            nd.setNx(first);
            first = nd;
        }
    }

    public Car pop() {
        if (size == 0) return null;
        size--;
        Car res = first.getCar();
        if (size == 0) {
            first = null;
            return res;
        }
        first = first.getNx();
        return res;
    }
}

class CarNode {

    private CarNode nx;

    private Car car;

    CarNode(Car car) {
        this.car = car;
    }

    public CarNode getNx() {
        return nx;
    }

    public void setNx(CarNode nx) {
        this.nx = nx;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
