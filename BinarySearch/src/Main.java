public class Main {
    public static void main(String[] args) {
        int[] arr = {-1,2,3,4,5,6,7,8,9,10};
        int target = 5;
        System.out.println(binarySearch(arr, target));
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target < arr[mid]) {
                high = mid - 1;
            }
           else if (target > arr[mid]) {
                low = mid + 1;
            }
           else{
               return mid;
            }
        }
        return -1;
    }
}