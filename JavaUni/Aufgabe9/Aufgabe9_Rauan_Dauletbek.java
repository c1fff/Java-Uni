//Rauan Dauletbek, #12337766
package einfprog;


public class Bsp09 {
    public static void main(String[] args) {
        Date deadline1 = Date.createDate(2024, 1, 31);
        System.out.println("Deadline 1: " + deadline1); 

        Task t0 = new Task("ExampleTask0");
        Task t1 = new TimedTask("ExampleTask1", deadline1);

        System.out.println("Task 0: " + t0);           
        System.out.println("Deadline for Task 1: " + ((TimedTask) t1).getDeadline()); 
        System.out.println("Task 1: " + t1);           

        TaskList tlist = new TaskList(5);
        System.out.println("TaskList Capacity: " + tlist.getCapacity());  

        tlist.addTask(t0);
        System.out.println("Tasks in TaskList: " + tlist);  

        tlist.addTask(t1);
        Task t2 = tlist.addTask("ExampleTask2");
        System.out.println("TaskList Count/Capacity: " + tlist.getCount() + "/" + tlist.getCapacity());  
        System.out.println("Adding Task 1 again: " + tlist.addTask("ExampleTask1"));  

        System.out.println("Task at index 0: " + tlist.getTask(0));  

        Date today = Date.createDate(2024, 1, 15);
        TaskList todosUntilToday = tlist.getTODOsDueUntil(today);
        System.out.println("TODOs until today: " + todosUntilToday); 
        System.out.println("Compact result: " + tlist.compact());  
        System.out.println("Compact Tasks in TaskList: " + tlist);  
    }
}
