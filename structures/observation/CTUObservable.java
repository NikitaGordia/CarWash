package structures.observation;

import models.CarWash;

import java.util.LinkedList;
import java.util.List;

public class CTUObservable {

    private List<CTUObserver> obs = new LinkedList<>();
    public void push(CTUObserver o){
        obs.add(o);
    }

    public void act(int tm, CarWash carWash) {
        for (CTUObserver i : obs) i.stop(tm, carWash);

        for (CTUObserver i : obs) i.prepare(tm, carWash);

        for (CTUObserver i : obs) i.start(tm, carWash);
    }
}