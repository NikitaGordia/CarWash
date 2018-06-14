package structures.observation;

import models.CarWash;

public interface CTUObserver {

    void stop(int tm, CarWash carWash);

    void prepare(int tm, CarWash carWash);

    void start(int tm, CarWash carWash);

}
