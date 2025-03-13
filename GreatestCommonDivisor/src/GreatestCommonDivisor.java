public class GreatestCommonDivisor {
    public static void main(String[] args) {
        int x=48;
        int y=18;
        System.out.println(findDiviser(x,y));
    }

    private static int findDiviser(int x, int y) {
        if (y == 0) {
            return x;
        }

        int result = x%y;
        if(result == 0){
            return y;
        }
        else{
           return findDiviser(y, result);
            }
        }
    }