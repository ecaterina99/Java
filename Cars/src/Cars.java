public class Cars {
    public static void main(String[] args) {
        Car myCar = new Car("Honda", "Accord", 1590, "red");

        myCar.setWeight(5000);

        Car myCar2 = new Car();
        myCar2.make = "Lexus";
        myCar2.model = "LS500";
        myCar2.color = "white";
        myCar2.setWeight(2800);

        System.out.println("The number of cars in the showroom is: " + Car.nrCarsInTheShowroom);

        System.out.println(myCar.getInfo());
        System.out.println(myCar2.getInfo());

        Convertible convertible1 = new Convertible("Opel", "Astra", 1274, "silver", "soft-top");

        System.out.println(convertible1.getInfo());
    }
}

