import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
    List<Task> tasks = new ArrayList<>();


    public void addTask() {
        Task newTask = new Task();

        if (this.tasks.isEmpty()) {
            newTask.setId(1);
        } else {
            newTask.setId(this.tasks.size() + 1);
        }
        System.out.println("Enter task description:");
        Scanner scanner = new Scanner(System.in);
        newTask.setDescription(scanner.nextLine());
        this.tasks.add(newTask);
        System.out.println("Task added successfully!");
    }

    public void markTaskAsCompleted(int taskId) {
        boolean taskExists = false;

        if (this.tasks.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Task eachTask : this.tasks) {
                if (taskId == eachTask.getId()) {
                    eachTask.markAsCompleted();
                    taskExists = eachTask.getIsCompleted();
                }
            }

            if (!taskExists) {
                System.err.println("The ID is incorrect. Please select a valid option!");
            } else {
                System.out.println("Task marked as completed!");
            }
        }
    }

    public void showAllTasks() {
        if (this.tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Current tasks:");
            for (Object eachTask : this.tasks) {
                System.out.println(eachTask);
            }
        }
    }

    public void deleteTask(int taskId) {
        if (this.tasks.isEmpty()) {
            System.out.println("The list is empty.");
        } else {

            boolean taskExists = false;

            Iterator<Task> iterator = this.tasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (taskId == task.getId()) {
                    iterator.remove();
                    taskExists = true;
                }
            }

            if (!taskExists) {
                System.err.println("The ID is not in the list!");
            } else {
                System.out.println("Task deleted successfully!");
            }
        }
    }


}
