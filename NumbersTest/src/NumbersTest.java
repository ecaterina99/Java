public class NumbersTest {
    public static void main(String[] args) {
        Integer myNumber1 = 15;
        Integer myNumber2 = 16;
        //metoda compară valorile numerice;
        System.out.println(myNumber1.compareTo(myNumber2));
        System.out.println(myNumber2.compareTo(myNumber1));

        //metoda utilizata pentru a obține valori simple (primitive) din obiectul învelişului
        Integer myNumber3 = 20;
        int myNumber4 = myNumber3.intValue();

        //Clasa Math
        System.out.println(Math.abs(-17));
        System.out.println(Math.min(17, 23));
        System.out.println(Math.max(17, 23));
        System.out.println(Math.sqrt(16));
        System.out.println(Math.pow(4, 2));
        System.out.println(Math.signum(-17));
        System.out.println(Math.random());

        System.out.println(Math.floor(5.4));
        System.out.println(Math.floor(5.5));
        System.out.println(Math.floor(5.6));
    }
}
