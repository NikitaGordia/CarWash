import models.CarWash;

public class Main {

    public static void main(String[] args) {
        CarWash wash = new CarWash(3, 720);
        wash.perform();
    }
}
