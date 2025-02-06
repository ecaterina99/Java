/*
Scrieți un program care acceptă de la utilizator un parametru.
Parametrul se referă la raza cercului. După introducerea valorii,
programul ar trebui să calculeze circumferința și aria cercului și să afișeze rezultatele la ieșire.
 */

import java.util.Scanner;

public class CircleAria {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter radius:");
        double radius = scanner.nextDouble();
        final double PI = 3.14;
        double area = PI * radius * radius;
        System.out.println("The area of the circle is " + area);
        double perimeter = 2 * PI * radius;
        System.out.println("The perimeter of the circle is " + perimeter);


    }
}
