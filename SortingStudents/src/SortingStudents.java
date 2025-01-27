/*
Today Suzuki will be interviewing his students to ensure they are progressing in their training.
He decided to schedule the interviews based on the length of the students name in descending order.
The students will line up and wait for their turn.
You will be given a string of student names. Sort them and return a list of names in descending order.
 */

import java.util.Arrays;


public class SortingStudents {
    public static void main(String[] args) {

        String[] lineupStudents = {"Ana", "Dan", "Catea", "Mara"};

        for (int i = 0; i < lineupStudents.length; i++) {
            for (int j = i + 1; j < lineupStudents.length; j++) {
                if (lineupStudents[i].length() < lineupStudents[j].length()) {
                    String temp = lineupStudents[i];
                    lineupStudents[i] = lineupStudents[j];
                    lineupStudents[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(lineupStudents));

        for (int i = 0; i < lineupStudents.length; i++) {
            for (int j = i + 1; j < lineupStudents.length; j++) {

                if (lineupStudents[i].compareToIgnoreCase(lineupStudents[j]) < 0 && lineupStudents[i].length() == lineupStudents[j].length()) {
                    String temp = lineupStudents[i];
                    lineupStudents[i] = lineupStudents[j];
                    lineupStudents[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(lineupStudents));


        //second solution
        String students = "Ana, Dan, Evelina, Mara";

        String[] res = students.split(", ");
        Arrays.sort(res, (a, b) -> (a.length() != b.length()) ? Integer.compare(b.length(), a.length()) : b.compareTo(a));
        System.out.println(Arrays.toString(res));
    }
}