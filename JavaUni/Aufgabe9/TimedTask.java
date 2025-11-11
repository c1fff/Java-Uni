package einfprog;

public class TimedTask extends Task {
    private final Date deadline;
    /** 
     * Creates a new TimedTask (which is not yet done) with the 
     * specified title and deadline; the title string must not 
     * be null (but can be empty) 
     */
    public TimedTask(String title, Date deadline) {
        super(title);
        this.deadline = deadline;// TODO: implement.
    }

    /** returns the deadline of the task */
    public Date getDeadline() {
        return deadline; // TODO: implement.
    }

    /** 
     * Returns the title of the task followed by a blank and the string 
     * representation of the deadline enclosed in parenthesis; e.g. 
     * "ExampleTask1 (2022-01-08)" 
     */
    public String toString() {
        return String.format("%s (%s)", getTitle(), deadline.toString()); // TODO: implement.
    }
}