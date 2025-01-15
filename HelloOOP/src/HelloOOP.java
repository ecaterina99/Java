public class HelloOOP {
    public static void main(String[] args) {

        int x; //variabila de tip primitiv;
        String test; //variabila de tip obiect/referinta
        Masina masina1 = new Masina(); //aloca spatiu in memorie pentru un nou obiect de tip masina
        Persoana vasilica = new Persoana(); //aloca spatiu in memorie pentru un nou obiect de tip persoana

        masina1.porecla = "Opel";
        masina1.culoare = "neagră";
        masina1.nrRoți = 4;
        masina1.maxSpeed = 170;

        Masina elRobin = new Masina();
        elRobin.porecla = "El Robin";
        elRobin.culoare = "rosie";
        elRobin.nrRoți = 3;
        elRobin.maxSpeed = 250;

        masina1.afiseaza();
        elRobin.afiseaza();
        elRobin.acceleraza();
        elRobin.afiseaza();
        boolean ePolitie = false;

        for (int i = 0; i < 20; i++) {
            double ceva = Math.random();
            // valorile inre 0 si 1;
            if (ceva < 0.1) {
                ePolitie = true;
            } else {
                ePolitie = false;
            }
            if (ePolitie) {
                masina1.deceleraza();
                masina1.afiseaza();
            } else {
                masina1.acceleraza();
                masina1.afiseaza();

            }

        }

        for (int i = 0; i < 20; i++) {
            double ceva = Math.random();
            // valorile inre 0 si 1;
            if (ceva < 0.1) {
                ePolitie = true;
            } else {
                ePolitie = false;
            }
            if (ePolitie) {
                elRobin.deceleraza();
                elRobin.afiseaza();
            } else {
                elRobin.acceleraza();
                elRobin.afiseaza();
            }
        }

        vasilica.nume = "Vasilica";
        vasilica.anNastere = 1995;
        vasilica.salariu = 1000;
        boolean anProblematic;
        for (int an = 2020; an < 2025; an++) {
            double ceva = Math.random();
            if (ceva < 0.3) {
                anProblematic = true;
            } else {
                anProblematic = false;
            }
            System.out.println("Suntem in anul " + an + ". Anul este " + (anProblematic ? "problematic" : "bun"));

            if (!anProblematic) {
                vasilica.maresteSalariu(10);
            } else {
                vasilica.maresteSalariu(-10);

            }
            vasilica.afiseaza(an);
        }

    }
}
