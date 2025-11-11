package einfprog;
import java.util.Arrays;

public class TaskList {
    private final Task[] tasks;
    private final int capacity;
    private int count;
    /**
     * creates a new TaskList with the given maximum capacity;
     * if capacity is smaller than zero, the capacity is set to 0
     */
    public TaskList(int capacity) {
        this.capacity = Math.max(capacity, 0);
        this.tasks = new Task[this.capacity];
        this.count = 0;
    }

    /**
     * returns the maximum capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * returns the number of actual (non-null) Task objects managed by the tasks array
     */
    public int getCount() {
        return count;
    }

    /**
     * Adds the given task to the tasks array at the first free position; 
     * returns true if the task was added successfully; otherwise returns false 
     * (i.e., the list has already reached the maximum capacity, or another task 
     * with the same title already exists, or task is `null` or the task's title 
     * is `null`)
     */
    public boolean addTask(Task task) {
        if (task == null || task.getTitle() == null || count >= capacity) {
            return false;
        }

        tasks[count++] = task;
        return true;
    }

    /**
     * adds a newly created `Task` with the given title to the tasks array at 
     * the first free position; returns the created task if the task was added 
     * successfully; otherwise returns null (i.e., the list has already reached 
     * the maximum capacity, or another task with the same title already exists,
     * or the title is `null`)
     */
    public Task addTask(String title) {
        if (title == null || count >= capacity) {
            return null;
        }

        Task newTask = new Task(title);
        tasks[count++] = newTask;
        return newTask;
    }

    /**
     * adds all given tasks to the tasks array (the order is retained; every 
     * task is added at the first free position); returns true if all the tasks 
     * were added successfully; otherwise returns false 
     * (see `addTask(Task task)`)
     */
    public boolean addTasks(Task[] newTasks) {
        if (newTasks == null || count + newTasks.length > capacity) {
            return false;
        }

        for (Task task : newTasks) {
            if (task != null && task.getTitle() != null) {
                tasks[count++] = task;
            }
        }

        return true;
    }

    /**
     * returns the task with the specified title, or `null` if no such task 
     * was found
     */
    public Task getTask(String title) {
        for (Task task : tasks) {
            if (task != null && task.getTitle().equals(title)) {
                return task;
            }
        }

        return null;
    }

    /**
     * returns the task at the specified index in the tasks array;
     * returns null if there is no task at this index, or the index is invalid 
     * (i.e., out-of-bounds).
     */
    public Task getTask(int idx) {
        if (idx < 0 || idx >= count) {
            return null;
        }

        return tasks[idx];
    }

    /**
     * prints the string representation (as obtained by `toString()`) of all 
     * tasks in the order of the tasks array; null-values are ignored. Tasks 
     * that are marked as done are only printed if `includeDone` is `true`
     */
    public void printTasks(boolean includeDone) {
        for (Task task : tasks) {
            if (task != null && (includeDone || !task.isDone())) {
                System.out.println(task);
            }
        }
    }
    /**
     * returns all elements in the array tasks (including null) as a list in 
     * [...] (see example):
     * [task0, task1, null, ....]
     */
    public String toString() {
        return Arrays.toString(tasks);
    }
    
    /** removes the task with the given title; returns the removed task or null 
      * if no task with that title was found 
      */
    public Task removeTask(String title) {
        for (int i = 0; i < count; i++) {
            if (tasks[i] != null && tasks[i].getTitle().equals(title)) {
                Task removedTask = tasks[i];
                tasks[i] = null;
                count--;
                return removedTask;
            }
        }
        return null;
    }

    /** returns a `TaskList` that contains all tasks which are not yet done 
     * (in the original order); if the task is a `TimedTask` it is only part of 
     * the returned list, if its deadline has not yet passed; the capacity of 
     * the returned list must be equal to the number of tasks in the list (i.e.
     * it must not contain `null` values). 
     */
    public TaskList getTODOsDueUntil(Date deadline) {
        TaskList result = new TaskList(count);

        for (Task task : tasks) {
            if (task != null && (!task.isDone() || (task instanceof TimedTask && ((TimedTask) task).getDeadline().compareTo(deadline) > 0))) {
                result.addTask(task);
            }
        }

        return result;
    }

    /** changes the tasks array to a compact representation by avoiding null 
     * values between individual tasks; this is achieved by shifting tasks to 
     * the leftmost free position while retaining the order of tasks; returns 
     * true only if at least one task changed its position 
     */
    public boolean compact() {
        int newIndex = 0;
        boolean taskChangedPosition = false;

        for (int i = 0; i < count; i++) {
            if (tasks[i] != null) {
                tasks[newIndex] = tasks[i];

                if (newIndex != i) {
                    taskChangedPosition = true;
                }

                newIndex++;
            }
        }

        // Clear remaining slots
        for (int i = newIndex; i < count; i++) {
            tasks[i] = null;
        }

        return taskChangedPosition;
    }
}