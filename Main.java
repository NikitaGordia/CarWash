import models.Car;
import structures.CarStack;

public class Main {

    public static void main(String[] args) {
        CarStack stack = new CarStack();
        stack.push(new Car(1, 67));
        stack.push(new Car(2, 67));
        stack.push(new Car(3, 67));
        stack.pop();
        stack.pop();
        stack.push(new Car(4, 34));
        stack.push(new Car(5, 43535));
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(new Car(7, 324));
        stack.pop();
        stack.go();
    }
}
