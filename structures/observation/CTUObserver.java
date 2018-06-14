package structures.observation;

import models.CarWash;

public abstract class CTUObserver {

    protected abstract void stop(int tm, CarWash carWash);

    protected abstract void prepare(int tm, CarWash carWash);

    protected abstract void start(int tm, CarWash carWash);

}
