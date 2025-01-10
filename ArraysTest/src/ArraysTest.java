/*
1)int[] arr = {1,2,3,4,5,6,7,8,9,10};
Trebuie listat şirul dat, folosind bucla while.
2)Modificaţi codul din exerciţiul anterior în aşa fel încât să se execute folosind bucla do-while.
3)Trebuie să creaţi un program care să stabilească dacă într-un şir există valoarea definită.
Programul trebuie scris fără utilizarea metodei binarySearch.
 */
public class ArraysTest {
    public static void main(String[] args) {
//1
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int x = 0;
        while (x < arr1.length) {
            System.out.println(arr1[x]);
            x++;
        }
//2
        int y = 0;
        do {
            System.out.println(arr1[y]);
            y++;
        }
        while (y < arr1.length);
//3
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
