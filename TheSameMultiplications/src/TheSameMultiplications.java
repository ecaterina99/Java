/*
Given two arrays a and b write a function comp(a, b) that checks whether the two arrays have
the "same" elements, with the same multiplicities (the multiplicity of a member is the number
of times it appears). "Same" means, here, that the elements in b are the elements in a squared,
regardless of the order. If a or b are null, the problem doesn't make sense so return false.
 */

import java.util.Arrays;

public class TheSameMultiplications {
    public static void main(String[] args) {
        int[] a = {2, 2, 3};
        int[] b = {4, 9, 9};

        if (a == null || b == null || b.length != a.length) {
            System.out.println("The arrays are not equal");
            //return false;
        }
        if (a.length == 0) {
            System.out.println("The arrays are empty");
            //return true;
        }

        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * a[i];
        }

        Arrays.sort(a);
        Arrays.sort(b);

        if (Arrays.equals(a, b)) {
            System.out.println("The arrays are the same");
            //return true;
        }else {
            System.out.println("The arrays are not equal");
            //return false;
        }
    }
}
