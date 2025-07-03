/*
You are given an array(list) strarr of strings and an integer k.
Your task is to return the first longest string consisting of k consecutive strings taken in the array.
n being the length of the string array, if n = 0 or k > n or k <= 0 return "".


 */

public class ConsecutiveStrings {
    public static void main(String[] args) {
        String[] arr = {"zone", "abigail", "thetaparma", "form", "libe", "zas", "theta", "abigail"};
        int maxWord=arr[0].length();
        String consecutiveStrings="";
        for(int i=1;i<arr.length;i++){
            if(arr[i].length()>maxWord){
                maxWord=arr[i].length();
                if(arr[maxWord-1].length()>arr[maxWord+1].length()){
                    consecutiveStrings=arr[maxWord-1]+arr[maxWord];
                }
            }
        }



        System.out.println(arr[maxWord]);
            System.out.println(consecutiveStrings);
    }
}