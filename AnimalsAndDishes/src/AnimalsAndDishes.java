/*
  All of the animals are having a feast! Each animal is bringing one dish.
  There is just one rule: the dish must start and end with the same letters as
  the animal's name. For example, the great blue heron is bringing garlic naan and the
  chickadee is bringing chocolate cake.

  Write a function feast that takes the animal's name and dish as arguments and returns
  true or false to indicate whether the beast is allowed to bring the dish to the feast.

  Assume that beast and dish are always lowercase strings, and that each has at least two letters.
  beast and dish may contain hyphens and spaces, but these will not appear
  at the beginning or end of the string. They will not contain numerals.
  */


public class AnimalsAndDishes {

    public static boolean feast(String beast, String dish) {


        char beastFirstChar = beast.charAt(0);
        System.out.println(beastFirstChar);

        int beastLastCharPos = beast.length() - 1;
        char beastLastChar = beast.charAt(beastLastCharPos);
        System.out.println(beastLastChar);


        char dishFirstChar = dish.charAt(0);
        System.out.println(dishFirstChar);
        int dishLastCharPos = dish.length() - 1;
        char dishLastChar = dish.charAt(dishLastCharPos);
        System.out.println(dishLastChar);

        return beastFirstChar == dishFirstChar && beastLastChar == dishLastChar;


    }

}