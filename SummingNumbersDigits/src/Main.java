//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int sumDigits = 0;
        int number = 25;

        if(number < 0){
            number = -number;
        }

        String digits = number+"";
        int length = digits.length();


        for(int i=0; i<length; i++){
            int num = Integer.parseInt(digits.substring(i,i+1));
            sumDigits = sumDigits + num;
        }
        System.out.println(sumDigits);

    }
}