public class PositiveNumbersSum {
    public static int sum(int[] arr){
        int result = 0;
        for( int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                result=result+arr[i];
            }
        }

//         for(int i : arr) sum += i > 0 ? i : 0;

        return result;
    }
}
