import java.util.*;
public class ToDoApp {
    private static final String LOGIN_USERNAME = "Pratik";
    private static final String LOGIN_PASSWORD = "one3514bat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (!username.equals(LOGIN_USERNAME) || !password.equals(LOGIN_PASSWORD)) {
            System.out.println("Invalid credentials. Exiting...");
            return;
        }

        ToDoList.loadTasksFromFile();

        while (true) {
            System.out.println("\n---- ToDo List Menu ----");
            System.out.println("1. Add a Task");
            System.out.println("2. Mark a Task as Done");
            System.out.println("3. Show Tasks");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    ToDoList.addTask(scanner);
                    break;
                case 2:
                    ToDoList.markTaskAsDone(scanner);
                    break;
                case 3:
                    ToDoList.showTasks();
                    break;
                case 4:
                    ToDoList.saveTasksToFile();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}