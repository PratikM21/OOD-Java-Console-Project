import java.io.*;
import java.util.*;
class ToDoList {
    private static List<Task> tasks = new ArrayList<>();
    private static final String FILE_NAME = "tasks.txt";

    public static void addTask(Scanner scanner) {
        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter Deadline (e.g., 23 November, 2023): ");
        String deadline = scanner.nextLine();

        System.out.print("Enter priority (1 - Low, 2 - Medium, 3 - High): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); 

        Task newTask = new Task(taskName, deadline, priority);
        tasks.add(newTask);
        System.out.println("Task added successfully!");
    }

    public static void markTaskAsDone(Scanner scanner) {
        showTasks();
        System.out.print("Enter the index of the task to mark as done: ");
        int index = scanner.nextInt();
        index= index-1;
        scanner.nextLine(); 

        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task marked as done and removed!");
        } else {
            System.out.println("Invalid index. No task removed.");
        }
    }

    public static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            tasks.sort(Comparator.comparing(Task::getPriority).reversed());
            int index = 1;
            for (Task task : tasks) {
                System.out.print("Task " + index + ":");
                System.out.println(task);
                System.out.println("--------------------");
                index++;
            }
        }
    }

    public static void loadTasksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] taskData = line.split(",", 3);
                if (taskData.length == 3) {
                    String taskName = taskData[0];
                    String deadline = taskData[1];
                    int priority = Integer.parseInt(taskData[2]);
                    Task task = new Task(taskName, deadline, priority);
                    tasks.add(task);
                } else {
                    System.out.println("Invalid data format in the file.");
                }
            }
            System.out.println("Tasks loaded successfully!");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }
    }

    public static void saveTasksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task task : tasks) {
                writer.write(task.getTaskName() + "," + task.getDeadline() + "," + task.getPriority());
                writer.newLine();
            }
            System.out.println("Tasks saved successfully!");
        } catch (IOException e) {
            System.out.println("Error occurred while saving tasks.");
        }
    }
}