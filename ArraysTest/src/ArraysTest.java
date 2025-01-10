/*
Trebuie să creaţi un program care să stabilească dacă într-un şir există valoarea definită.
Programul trebuie scris fără utilizarea metodei binarySearch.
 */
public class ArraysTest {
    public static void main(String[] args) {
        int[] array = {1, 5, 33, 563, 0, 2, 23, 9, 9, 11, 987, 23, 934, 999, 43};
        int searchValue = 23;
        boolean found = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == searchValue) {
                found = true;
                System.out.println("Found value: " + array[i] + "; posititon: " + i);
                break;
            }
        }
        if (!found) {
            System.out.println("Value not found");
        }

        //second method

        int[] arr2 = {1, 5, 33, 563, 0, 2, 23, 9, 9, 11, 987, 23, 934, 999, 43};

        System.out.println(searchArray(arr2, 12));
        System.out.println(searchArray(arr2, 999));

    }

    private static boolean searchArray(int[] array, int i) {
        for (int value : array) {
            if (value == i) {
                return true;
            }
        }
        return false;
    }
}
