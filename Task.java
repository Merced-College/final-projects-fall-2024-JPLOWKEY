// Task class to store and manage task functionality in the TaskManager 
//11-15-2024


public class Task {
   private String title;
   private int priority; // 1 = Low, 2 = Medium, 3 = High
   private String dueDate; // YYYY-MM-DD
   private String notes;

    // Constructor for new tasks and its functionality 
   public Task(String title, int priority, String dueDate, String notes) {
       this.title = title;
       this.priority = priority;
       this.dueDate = dueDate;
       this.notes = notes;
   }

   // Getter to get title 
   public String getTitle() {
       return title;
   }
   // Setter for title update
   public void setTitle(String title) {
       this.title = title;
   }
   // Getter to get the priority
   public int getPriority() {
       return priority;
   }
   // Setter to update task priority 
   public void setPriority(int priority) {
      this.priority = priority;
   }
   // Getter function to get the task's due date  
   public String getDueDate() {
       return dueDate;
   }
   // Setter to update the task's due date 
   public void setDueDate(String dueDate) {
       this.dueDate = dueDate;
   }
   // Getter to get task the notes
   public String getNotes() {
       return notes;
   }
   // Setter to update task the notes
   public void setNotes(String notes) {
       this.notes = notes;
   }

   @Override
   public String toString() {
       return "Task: " + title + "\nPriority: " + getPriorityAsString() + "\nDue Date: " + dueDate + "\nNotes: " + notes;
   }

   private String getPriorityAsString() {
       switch (priority) {      
          case 1: return "Low";
          case 2: return "Medium";
          case 3: return "High";
          default: return "Unknown";
       }
   }
}
