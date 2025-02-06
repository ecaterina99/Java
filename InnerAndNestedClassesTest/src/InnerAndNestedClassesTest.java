public class InnerAndNestedClassesTest {
    public static void main(String[] args) {

        //Inner class - poate fi instanţiată doar folosind obiectele clasei în care sunt situate.
        Electrocar electrocar = new Electrocar(1);
        electrocar.start();


        //Static nested class - poate fi accesată folosind numele clasei părinte, fără instanţierea sa prealabilă
        Electrocar.Battery battery = new Electrocar.Battery();
        battery.chargeBattery();



     }
}
