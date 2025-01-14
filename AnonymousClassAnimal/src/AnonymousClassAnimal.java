public class AnonymousClassAnimal {
    public static void main(String[] args) {

        Animal animal = new Animal();
        animal.eat();

        Animal dog = new Animal() {
            public void eat() {
                // crearea unei noi clase fără nume, motiv pentru care se numeşte clasă anonimă;
                //Extinde clasa Animal
                //utilizarea unică
                //În interiorul acoladelor metoda eat este suprascrisă.
                //este vizibila doar in acest bloc de cod
                System.out.println("Dog isn't eating");
            }
        };
        dog.eat(); // se execută versiunea suprascrisă
        animal.eat(); // se execută versiunea originală



        AbleToSleep  ableToSleep = new AbleToSleep() {
            public void sleep() {  // crearea unei noi clase anonime fără nume
                //implementează interfața Able to sleep

                System.out.println("Someone is sleeping");
            }
        };
        ableToSleep.sleep(); // este obligatorie implementarea metodei sleep
    }
}
