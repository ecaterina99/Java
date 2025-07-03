public class Bebelus extends Persoana {
    float greutate;

    Bebelus() {
        super("Bebelus");
        System.out.println("Constructor Bebelus");
    }

    Bebelus(float greutate) {
        System.out.println("S-a nascut de greutate + " + greutate + " kg");
    }

    //supraincarcare pe metoda
    void scanceste() {
        System.out.println("uguuuu gagaaa");
    }

    void scanceste(String sunet) {
        System.out.println(nume + ": " + sunet);
    }

    @Override
        //annotation - suprascriere (overwriting)
    void vorbeste() {
        System.out.println("Buna, sunt un bebelus! ");
    }

}
