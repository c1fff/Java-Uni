package einfprog;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private List<Row> rows;
    /**
     * Create a new table.
     * 
     * @param name The name of the table.
     */
    public Table(String name) {
        this.name = name;
        this.rows = new ArrayList<>();// TODO: implement.
    }

    /**
     * Set the name of this table.
     */
    public String getName() {
        return this.name; // TODO: implement.
    }

    /**
     * Get the name of this table
     */
    public void setName(String name) {
        this.name = name;// TODO: implement.
    }

    /**
     * Get a string representation of this table.
     */
    @Override
    public String toString() {
        return "{" + getName() + "}"; // TODO: implement.
    }
    
    // Ignore this. It’s here for the tests to work properly.
    protected Table() {}
}
