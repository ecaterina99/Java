public class Array {
    public static void main(String[] args) {
        //array 1
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i*10;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //array 2
        int[] arr2 = {1,2,3,4,5};
        for (int j : arr2) {
            System.out.println(j + 10);
        }
    }
}
