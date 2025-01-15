public class Persoana {
    String nume;
    int anNastere;
    float salariu;

    void creste () {
        salariu ++;
    }

    //antet netoda(paramentri formali)
    void afiseaza(int an){
        System.out.println("Persoana "+ nume + ", in varstra de " + (an-anNastere) + " de ani a primit salariul de "+ salariu + " EUR in anul " + an );
    }

    void maresteSalariu (int procent){
       salariu +=  (float) procent /100 * salariu;
    }

}
