public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 9, 4, 1};
        selectSort(arr);
        for (int j : arr) System.out.print(j + " ");
    }

    private static void selectSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}