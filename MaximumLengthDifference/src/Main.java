/*
You are given two arrays a1 and a2 of strings.
Each string is composed with letters from a to z.
Find max(abs(length(x) − length(y)))
 */

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String[] a1 = {"hoqq", "bbllkw", "oox", "ejjuyyy", "plmiis", "xxxzgpsssa", "xxwwkktt", "znnnnfqknaz", "qqquuhii", "dvvvwz"};
        String[] a2 = {"cccooommaaqqoxii", "gggqaffhhh", "tttoowwwmmww"};

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        int res;

        if (a1.length == 0 || a2.length == 0) {
            res = 0;
        } else {
            for (String s : a1) {
                first.add(s.length());
            }
            for (String s : a2) {
                second.add(s.length());
            }

            Collections.sort(first);
            Collections.sort(second);

            int minFirst = first.getFirst();
            int minSecond = second.getFirst();
            int maxFirst = first.getLast();
            int maxSecond = second.getLast();

            int diff1 = maxFirst - minSecond;
            int diff2 = maxSecond - minFirst;

            res = Math.max(diff1, diff2);
        }

        System.out.println(res);

    }
}