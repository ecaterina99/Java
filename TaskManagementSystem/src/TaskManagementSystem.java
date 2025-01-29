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

        TaskManager manager = new TaskManager();

        System.out.println("Please, select the option");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        selectOption(manager, userInput);
        while (userInput != 5) {
            System.out.println("Please, select the option between 1 and 5");
            try {
                userInput = scanner.nextInt();
                selectOption(manager, userInput);
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    public static void selectOption(TaskManager manager, int userInput) {
        switch (userInput) {

            case 1 -> manager.addTask();

            case 2 -> manager.showAllTasks();

            case 3 -> {
                System.out.println("Enter task ID to mark as completed:");
                Scanner sc = new Scanner(System.in);
                int taskId = sc.nextInt();

                manager.markTaskAsCompleted(taskId);
            }

            case 4 -> {
                System.out.println("Enter task ID to delete:");
                Scanner sc = new Scanner(System.in);
                int taskId = sc.nextInt();
                manager.deleteTask(taskId);
            }

            case 5 -> System.out.println("Exiting the program. Goodbye!");

            default -> System.err.println("The ID is incorrect. Please select a valid option between 1 and 5.");
        }
    }
}

