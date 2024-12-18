public class Paper {
    public static int paperWork(int n, int m) {
        int result;
        if (n < 0 || m < 0) {
            return 0;
        } else {
            result = m * n;
            return result;
        }
    }
}

// return (n < 0) || (m < 0) ? 0 : n * m;