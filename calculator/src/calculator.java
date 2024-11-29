public class calculator {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;

        System.out.printf("The value of x is %d%nThe sum of x and y is %d \n",x,x+y);
        System.out.printf("The difference of x and y is %d \n",x-y);
        System.out.printf("The result of x and y is %d \n",x*y);
        System.out.printf("The division of x and y is %d \n",x/y);

        x++;
        y--;
        System.out.printf("The value of x is %d\nThe value of y is %d\n",x,y);

        x += 5;
        System.out.printf("The value of x is %d\n",x);

        System.out.println(x==y);
        System.out.println(x>y);
        System.out.println(x<y);


    }
}