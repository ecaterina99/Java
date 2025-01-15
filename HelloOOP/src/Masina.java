public class Masina {
    String porecla;
    int nrRoți; //proprietatea clasei Masina
    String culoare; //proprietatea clasei Masina
    int viteza = 0;
    int maxSpeed;

    void afiseaza() {
        System.out.println("Masina " + porecla + " are " + nrRoți + " roti, culoarea " + culoare + " si viteza " + viteza + " km/h");
    }

    void acceleraza() {
        if (viteza + 10 <= maxSpeed) {
            viteza += 10;
        }
    }

    void deceleraza() {
        if (viteza > 8) {
            viteza -= 8;
        }
    }

}
