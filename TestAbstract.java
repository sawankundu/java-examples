package JavaTheory;
interface Car{
    public String nameOfCar();

    public static void engine(){
        System.out.println("engine of the car");
    };
}

class Maruti implements Car{

    @Override
    public String nameOfCar() {
        return "Maruti";
    }
}
abstract class Phone{
    public abstract String nameOfPhone();

    public void feature(){
        System.out.println("Snapdragon Processor");
    }
}
class Apple extends Phone{

    @Override
    public String nameOfPhone() {
        return "Apple";
    }

    public void feature(){
        System.out.println("Own Processor");
    }
}
public class TestAbstract {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println(apple.nameOfPhone());
        apple.feature();

        Maruti maruti = new Maruti();
        System.out.println(maruti.nameOfCar());
        Car.engine();
    }
}
