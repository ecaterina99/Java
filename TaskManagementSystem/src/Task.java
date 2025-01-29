import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Task {
    private int id;
    private String description;
    boolean isCompleted;

    public Task() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setDescription() {
        System.out.println("Enter task description:");
        Scanner scanner = new Scanner(System.in);
        this.description = scanner.nextLine();
    }

    public String getDescription() {
        return this.description;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public boolean getIsCompleted() {
        return this.isCompleted;
    }

    @Override
    public String toString() {
        return "[ID: " + getId() + "] " + getDescription() + "\n" + "Completed: " + this.isCompleted;
    }

    public void addTask(List<Task> allTasks, Task newTask) {
        if (allTasks.isEmpty()) {
            newTask.setId(1);
        } else {
            newTask.setId(allTasks.size() + 1);
        }
        newTask.setDescription();
        allTasks.add(newTask);
        System.out.println("Task added successfully!");
    }

    public void showAllTasks(List<Task> allTasks) {
        if (allTasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Current tasks:");
            for (Object eachTask : allTasks) {
                System.out.println(eachTask);
            }
        }
    }

    public void completeTask(List<Task> allTasks) {
        System.out.println("Enter task ID to mark as completed:");
        Scanner sc = new Scanner(System.in);
        boolean taskExists = false;
        int input = sc.nextInt();

        if (allTasks.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            for (Task eachTask : allTasks) {

                if (input == eachTask.getId()) {
                    eachTask.setIsCompleted(true);
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

    public void deleteTask(List<Task> allTasks) {
        System.out.println("Enter task ID to delete:");

        if (allTasks.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            boolean taskExists = false;

            Iterator<Task> iterator = allTasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (input == task.getId()) {
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


