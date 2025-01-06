import java.util.Arrays;
import java.util.function.IntPredicate;


//without Lambda


public class AnonymousClassLambdaTest {

    public static void main(String[] args) {

        int[] numbers = {12, 8, -9, 15, -1, 6, -26, 74};

        numbers = Arrays.stream(numbers).filter(new IntPredicate() {
            public boolean test(int number) {
                return (number % 2 == 0);
            }
        }).toArray();

        System.out.println(Arrays.toString(numbers));


        //with Lambda

        int[] numbers2 = {10, 8, -9, 15, 0, 6, -26, 74};

        numbers2 = Arrays.stream(numbers2).filter(number -> (number > 0)).toArray();

        System.out.println(Arrays.toString(numbers2));


        // Method references

        int[] numbers3 = {-2, -1, 0, 1, 2, 3, 4};
        Arrays.stream(numbers3).forEach(System.out::println);

    }
}
