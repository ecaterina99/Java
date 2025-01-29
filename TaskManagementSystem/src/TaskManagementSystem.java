import java.util.*;

public class TaskManagementSystem {
    public static void main(String[] args) {
        Map<String, Integer> options = new LinkedHashMap<>();

        options.put("Add a task.", 1);
        options.put("View all tasks.", 2);
        options.put("Mark a task as complete.", 3);
        options.put("Delete a task.", 4);
        options.put("Exit the program.", 5);

        options.forEach((key, value) -> System.out.println(value + ": " + key));

        List<Task> tasks = new ArrayList<>();

        Task newTask = new Task();

        System.out.println("Please, select the option");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        selectOption(tasks, userInput, newTask);
        while (userInput != 5) {
            System.out.println("Please, select the option between 1 and 5");
            try {
                userInput = scanner.nextInt();
                selectOption(tasks, userInput, newTask);
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    public static void selectOption(List<Task> tasks, int userInput, Task newTask) {
        switch (userInput) {

            case 1 -> newTask.addTask(tasks, newTask);

            case 2 -> newTask.showAllTasks(tasks);

            case 3 -> newTask.completeTask(tasks);

            case 4 -> newTask.deleteTask(tasks);

            case 5 -> System.out.println("Exiting the program. Goodbye!");

            default -> System.err.println("The ID is incorrect. Please select a valid option between 1 and 5.");
        }
    }
}

