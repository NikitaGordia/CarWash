import models.Car;
import models.CarWash;
import structures.CarStack;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
        CarWash wash = new CarWash(3, 720);
        wash.perform();
    }
}
