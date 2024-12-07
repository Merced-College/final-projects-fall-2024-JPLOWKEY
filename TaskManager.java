//TaskManager main class providing the actaul functional part of the app
//Juan Padilla
//11-19-2024

import java.util.LinkedList; // Import LinkedList
import java.util.Queue; // Import Queue 
import java.util.Scanner; // Import Scanner 

public class TaskManager {
    private Queue<Task> taskQueue = new LinkedList<>(); // Using to store tasks and allow for dynamic functions
    private Scanner scanner = new Scanner(System.in); // read user input

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        manager.run();
      }
    
    public void run() {
        boolean running = true; // program loop control
        while (running) {                           // Main loop
            System.out.println("\nTask Manager");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
           
            System.out.print("Choose an option: "); // ask user for select options
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                
               case 1: addTask(); break;
               case 2: viewTasks(); break;
               case 3: updateTask(); break;
               case 4: deleteTask(); break;
               case 5: running = false; break;
               default: System.out.println("Invalid option, try again.");
            }
        }
    }
    // Method to add task based on user command 
    private void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine();

        System.out.print("Task priority (1 = Low, 2 = Medium, 3 = High): ");
        int priority = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Due date (YYYY-MM-DD): ");
        String dueDate = scanner.nextLine();

        System.out.print("Enter notes: ");
        String notes = scanner.nextLine();

        Task newTask = new Task(title, priority, dueDate, notes); // new task object
        taskQueue.add(newTask); // new Linked list added
        System.out.println("Task added.");
    }
    // Fuction to display all task in in LinkedList
    private void viewTasks() {
        if (taskQueue.isEmpty()) {  //check if queue the is emtpy
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nTask List:");
            for (Task task : taskQueue) {    // loop through all tasks and display
                System.out.println(task);
                System.out.println("----------------------------"); // this works to separate tasks 
            }
        }
    }
     // Function to update an existing task based user input
    private void updateTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("There are no tasks yet, type 1 to make one!");
            return;
        }

        System.out.print("Enter the title of the task to update: ");
        String title = scanner.nextLine();

     // Search for the task in queue
        for (Task task : taskQueue) {   
            if (task.getTitle().equalsIgnoreCase(title)) {
               System.out.print("Enter new title (leave blank to keep current): ");
               String newTitle = scanner.nextLine();
               if (!newTitle.isEmpty()) task.setTitle(newTitle); // Update title if input  not blank

               System.out.print("Enter new priority (1 = Low, 2 = Medium, 3 = High): ");
               int newPriority = scanner.nextInt();
               scanner.nextLine(); // Consume newline
               task.setPriority(newPriority);

               System.out.print("Enter new due date (leave blank to keep current): ");
               String newDueDate = scanner.nextLine();
               if (!newDueDate.isEmpty()) task.setDueDate(newDueDate); // Update due date if input not blank

               System.out.print("Enter new notes (leave blank to keep current): ");
               String newNotes = scanner.nextLine();
               if (!newNotes.isEmpty()) task.setNotes(newNotes); // Update notes if input not blank

                System.out.println("Task updated successfully.");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    //Delete task function
    private void deleteTask() {
        if (taskQueue.isEmpty()) {
           System.out.println("No tasks available to delete.");
            return;
        }

        System.out.print("Enter the title of the task to delete: ");
        String title = scanner.nextLine(); // read user response to task title to delete
        
        // Iterate through the queue and remove matching task
      
        for (Task task : taskQueue) {
            if (task.getTitle().equalsIgnoreCase(title)) {  // Found Task
                taskQueue.remove(task); // Remove 
                System.out.println("Task deleted successfully.");
                return; // Exit
            }
        }

        System.out.println("Task not found.");
    }
}

