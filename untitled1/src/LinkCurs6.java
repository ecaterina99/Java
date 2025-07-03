public class LinkCurs6 {
    public static void main(String[] args) {
        Persoana p = new Persoana();
        p.nume = "Vasilica";
        p.vorbeste();

        Persoana p2 = new Persoana("Ana", true);
        p2.vorbeste();

        Persoana p3 = new Persoana("Link");
        p3.vorbeste();

        Bebelus b = new Bebelus();
        b.nume = "Bebelus Max";
        b.vorbeste();
        b.scanceste();

        Bebelus b2 = new Bebelus();
        b2.nume = "Bebelus Bob";
        b2.vorbeste();
        b.scanceste();

        Bebelus b3 = new Bebelus(5.4f);
        b3.scanceste("Uaaaaaa");
        b3.vorbeste();

        Persoana.showNrPersoane();

    }
}