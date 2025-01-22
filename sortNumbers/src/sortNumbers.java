public class sortNumbers {
    public static void main(String[] args) {
        int[] numbers ={2,1,3,5,4};
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                if(numbers[i]>numbers[j]){
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for(int i=0; i<numbers.length; i++){
            System.out.print(numbers[i]+" ");
        }
    }
}
