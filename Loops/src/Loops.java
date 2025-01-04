import java.util.Arrays;

public class Loops {
    public static void main(String[] args) {

        int x;
        for (x = 1; x <= 100; x += 2) {
            System.out.println("x= " + x);
        }

        int y = 3;
        y *= 2;
        System.out.println("y= " + y);

        y += 5 * 3;
        System.out.println("y= " + y);

        String sir = "Hello, ";
        sir += "World";
        System.out.println("sir= " + sir);

        int div = 7;
        for (x = 1; x <= 100; x++) {
            if (x % div == 0) {
                System.out.println(x + " este divizibil cu " + div);
            }
        }

        int p = 90;
        int array[] = {5, 11, 2, 17, 9, 3, 99, 9, -8};
        System.out.println("array= " + Arrays.toString(array));
        System.out.println("p= " + p);
        System.out.println(array[7]);
        System.out.println("The number of numbers is: " + array.length);


        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        String output = "";
        for (int i = 0; i < array.length; i++) {
            output += array[i];
            if (i != array.length - 1) {
                output += array[i] + ", ";
            }
        }
        System.out.println("Array: " + output);


        String students[] = {"David", "Bob", "Ana", "Maria", "Adrian", "Ecaterina"};
        for (String student : students) {
            int lengthOfTheName = student.length();
            char c = student.charAt(0);
            int lastCharacter = student.length() - 1;
            char c2 = student.charAt(lastCharacter);
            System.out.println("Student: " + student + " (The length of the name = " + lengthOfTheName + " ) " +
                    "(The first character is:  " + c + " ) " + "(The last character is:  " + c2 + " )");
        }

//        String students[]=String[] students

        boolean rain;
        double aleator = Math.random();
        if (aleator < 0.5) {
            rain = true;
        } else {
            rain = false;
        }

//        String rainString;
//        if(rain){
//            rainString = "It's raining outside";
//        }
//        else{
//            rainString = "It's not raining outside";
//        }
//        System.out.println("Is it raining outside?"+rainString);

//        System.out.println("Is it raining outside?" + (rain ? "It's raining outside" : "It isn't raining outside"));
//
//
//        double[] numbers = new double[20];
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = Math.random();
//        }
//        for (double number : numbers) {
//            System.out.print(number + "\n");
//        }
//
//    }
//}









//        Make a program that filters a list of strings and returns a list with only your friends name in it.
//
//        If a name has exactly 4 letters in it, you can be sure that it has to be a friend of yours! Otherwise, you can be sure he's not...
//
//        Input = ["Ryan", "Kieran", "Jason", "Yous"]
//        Output = ["Ryan", "Yous"]
//
//        Input = ["Peter", "Stephen", "Joe"]
//        Output = []
//        Input strings will only contain letters.
//        Note: keep the original order of the names in the output.
//
//
//import java.util.*;
//        class Kata {
//            public static List<String> friend(List<String> names){
//
//                List<String> myFriends = new ArrayList<String>();
//
//
//                for (String name : names ) {
//
//                    if (name.length() == 4) {
//                        myFriends.add(name);
//                    }
//
//                }
//
//                return myFriends;
//            }
//        }
//
//


//        You are going to be given a non-empty string. Your job is to return the middle character(s) of the string.
//
//        If the string's length is odd, return the middle character.
//        If the string's length is even, return the middle 2 characters.

//        class Kata {
//            public static String getMiddle(String word) {
//
//                int lengthOfString = word.length();
//                int half =  lengthOfString / 2;
//                System.out.println(word + " length Of String is: " + lengthOfString );
//
//
//                if(lengthOfString % 2 == 0 ){
//                    System.out.println ( "Odd number" );
//
//
//                    char Odd1 = word.charAt(half - 1);
//                    char Odd2 = word.charAt(half);
//                    String middleOdd = new String(new char[]{Odd1, Odd2});
//                    return middleOdd;
//                }
//
//                else{
//                    System.out.println ( "Even number" );
//
//
//                    char Even = word.charAt(half);
//                    String middleEven=new String(new char[]{Even});
//                    return middleEven;
//                }
//            }
//        }

