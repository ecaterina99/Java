public class ExceptionTest2 {
    static int calculate(int a, int b, String op){
        if (op.equals("+"))
            return a + b;
        if (op.equals("-"))
            return a - b;
        if (op.equals("/")) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }
            return a / b;
        }
        if (op.equals("*"))
            return a * b;
        return 0;
    }

    public static void main(String[] args) {
        int x = 0;
        try {
            x = calculate(5, 0, "/");
            System.out.println(x);
        } catch (ArithmeticException ex) {
            System.out.println("There is an error: " + ex.getMessage());
        }
    }

    //varianta 2

//    {
//        if(op.equals("+"))
//            return a + b;
//        if(op.equals("-"))
//            return a - b;
//        if(op.equals("/")){
//            try {
//                return a / b;
//            }
//            catch (ArithmeticException exc) {
//                System.out.println("There is an error");
//            }
//        }
//        if(op.equals("*"))
//            return a * b;
//        return 0;
//    }
//
//    public static void main(String[] args)
//    {
//        int x = calculate(5, 0, "/");
//        System.out.println(x);
//    }
}
