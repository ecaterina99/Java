public class InnerAndNestedClassesTest {
    public static void main(String[] args) {

        Electrocar electrocar = new Electrocar(1);
        electrocar.start();


        //Static nested class - poate fi accesat folosind numele clasei părinte, fără instanţierea sa prealabilă
        Electrocar.Battery battery = new Electrocar.Battery();
        battery.chargeBattery();



     }
}
