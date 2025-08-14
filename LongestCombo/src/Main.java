import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int k = 2;
        String[] strarr = {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"};
        int n = strarr.length;
        String longest = "";
        if(n==0 || k>n || k<=0||strarr.length==0){
            System.out.println("");
        }else {

            for (int i = 0; i <= n-k; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < k; j++) sb.append(strarr[i+j]);
                String candidate = sb.toString();
                if (candidate.length() > longest.length()) {
                    longest = candidate;
                }
            }
        }
        System.out.println(longest);

    }
}