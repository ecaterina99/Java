public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 9, 7, 8, 1, 4};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    private static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int middle = arr.length / 2;
        int[] left = new int[middle];
        int[] right = new int[arr.length - middle];

        int i = 0; //left array
        int j = 0; //right array

        for (; i < arr.length; i++) {
            if (i < middle) {
                left[i] = arr[i];
            } else {
                right[j] = arr[i];
                j++;
            }
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, arr);

    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while(l < leftSize && r < rightSize) {
            if(leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}