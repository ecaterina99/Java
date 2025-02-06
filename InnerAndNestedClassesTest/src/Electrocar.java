public class Electrocar {
    private int id;

    //Inner class (Clasa imbricata nestatica)
    //Clasa Electrocar este compusă din elemente diferite, la fel cum o mașină este alcătuită din diverse componente.
    private class Motor {
        public void startMotor() {
            System.out.println("Motor " + id + " is starting");
            //are acces la toate câmpurile si metodele clasei Electrocar
            //clasa este logic legata de obiectul clasei exterioare
        }
    }


//Static Nesgted class
    public static class Battery{
        public void chargeBattery() {
            System.out.println("Battery charging is started");
            //nu are acces direct  la toate câmpurile si metodele clasei Electrocar
            //avem acces doar la câmpurile statice(dacă ele sunt)
            //poate fi folosita independent de obiectul clasei
        }
    }

    public Electrocar(int id) {
        this.id = id;
    }

    public void start() {
        Motor motor = new Motor();
        motor.startMotor();

        System.out.println("Electrocar " + id + " is starting...");


        final int maxSpeed= 240;
        //Clasa locala are acces la variabilele final metodei Start (price) si la câmpurile clasei Electrocar
        //Este accesibil doar in interiorul acerstei metode


        class LocalClass{
            public void attentonMethod() {
                System.out.println("Local class " + id + " is running");
                System.out.println("Attention! " + maxSpeed + " is the maximum speed of Electrocar");
            }
        }
        LocalClass localObject = new LocalClass();
        localObject.attentonMethod();

    }
}
