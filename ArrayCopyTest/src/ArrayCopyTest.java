import java.util.Arrays;

public class ArrayCopyTest {
    public static void main(String[] args) {
        int[] array = {3, 5, 2, 6, 1, 6};
        int[] array1 = {12, 13, 14};

        int[] destArray = new int[array.length + array1.length];

        System.arraycopy(array, 0, destArray, 0, array.length);
        System.arraycopy(array1, 0, destArray, array.length, array1.length);

        System.out.println("Array length is: " + destArray.length);

        System.out.println("Elements are: ");
        System.out.println(Arrays.toString(destArray));

        Arrays.sort(destArray);
        System.out.println("Sorted array is: ");
        System.out.println(Arrays.toString(destArray));


        System.out.println(Arrays.binarySearch(destArray, 2));
        System.out.println(Arrays.binarySearch(destArray, 18));

        

    }

}
