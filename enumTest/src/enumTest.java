public class enumTest {
    public static void main(String[] args) {

        Size size = Size.SMALL;

        //Afişarea membrilor enumerării
        for (int i = 0; i < Size.values().length; i++) {
            System.out.println(Size.values()[i]);
        }

        //Enumerări în blocuri condiţionale if-else
        if (size == Size.SMALL) {
            System.out.println("Your size is S");
        } else if (size == Size.MEDIUM) {
            System.out.println("Your size is M");

        } else if (size == Size.LARGE) {
            System.out.println("Your size is L");
        } else {
            System.out.println("Your size is XL");
        }


        //Enumerări în blocuri condiţionale switch
        switch (size) {
            case SMALL -> System.out.println("Your size is S");
            case MEDIUM -> System.out.println("Your size is M");
            case LARGE -> System.out.println("Your size is L");
            case EXTRA_LARGE -> System.out.println("Your size is XL");
        }


        //Obţinerea enumerării pe baza numelui său
        Size size1 = Size.LARGE;

        Size size2 = Size.UNSPECIFIED;

        //Obţinerea enumerării pe baza numelui său.
        try {
            size2 = Size.valueOf("MEDI");
        } catch (IllegalArgumentException exc) {
            System.out.println(exc);
        }
        System.out.println(size2);
        System.out.println(size2.ordinal());


        //Definirea metodelor în cadrul enumerărilor
        for (int i = 0; i < Size.values().length; i++) {
            System.out.println(Size.values()[i].ordinal() + ":" + Size.values()[i].name() + " " + Size.values()[i].getCode());
        }

    }
}
