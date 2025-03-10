public class LinearSearchVsBinarySearch {
    public static void main(String[] args) {

        //linear Search
        int[] arr = {1, 5, 7, 6, 3, 9, 18};
        int index = linearSearch(arr, 9);
        if (index == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index " + index);
        }

        //Binary Search
        int[] arr2 = new int[10000];
        int target = 9000;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }
        int index2 = binarySearch(arr2, target);
        if (index2 == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element " + target + " found at index " + index2);
        }

    }


    private static int linearSearch(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int value = array[mid];
            System.out.println("Middle: " + value);
            if (value < target) {
                low = mid + 1;
            } else if (value > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

}