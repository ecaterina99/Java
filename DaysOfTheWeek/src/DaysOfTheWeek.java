
public class DaysOfTheWeek {
    public static void main(String[] args) {
        String[] week = {"Sunday", "Monday", "Wednesday", "Thursday", "Tuesday", "Friday", "Saturday"};
        char[] result = new char[week.length - 1];
        int arr[] = new int[week.length];

        for (int i = 0; i < week.length; i++) {
            if (week[i].equals("Monday")) {
                arr[i] = 0;
            } else if (week[i].equals("Tuesday")) {
                arr[i] = 1;
            } else if (week[i].equals("Wednesday")) {
                arr[i] = 2;
            } else if (week[i].equals("Thursday")) {
                arr[i] = 3;
            } else if (week[i].equals("Friday")) {
                arr[i] = 4;
            } else if (week[i].equals("Saturday")) {
                arr[i] = 5;
            } else if (week[i].equals("Sunday")) {
                arr[i] = 6;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (arr[i] < arr[i + 1]) {
                result[i] = '>';
            } else if (arr[i] > arr[i + 1]) {
                result[i] = '<';
            } else {
                result[i] = '=';
            }
        }
            for (int j = 0; j < result.length; j++) {
                System.out.print(week[j] + " " + result[j] + " ");
            }
            System.out.print(week[6]);
    }
} 