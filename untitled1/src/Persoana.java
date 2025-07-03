public class Persoana {
    String nume;
    boolean eFata;
    static int nrPersoane;

    static void showNrPersoane() {
        System.out.println("Nr persoane: " + nrPersoane);
    }

    //Supraincarcare (overloading ) mai mulți constructori (metode) cu acelasi nume, dar cu paramentri diferite
    Persoana() {
        this(null, false);
    }

    Persoana(String nume) {
        this(nume, false);
    }

    Persoana(String nume, boolean eFata) {
        if (nume == null) {
            this.nume = "P.Necunoscut";
        } else {
            this.nume = numeCurat(nume);
        }
        this.eFata = eFata;
        nrPersoane++;
    }

    String numeCurat(String nume) {
        if (nume.equals("Link")) {
            nume = "Interzis";
        }
        return nume;
    }

    void vorbeste() {
        System.out.println(nume + " (" + (eFata ? "fata" : "baiat") + "): Buna seara");
    }
}
