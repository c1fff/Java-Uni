package einfprog;
import java.util.List;
import java.util.Arrays;

public class FixedSizeTable extends Table {
    private int capacity;
    private Row[] rows;
    private int size;
    
    /**
     * Create a new fixed-size table.
     *
     * @param name The name of the table
     * @param capacity How many rows this table should store.
     */
    public FixedSizeTable(String name, int capacity) {
        super(name);
        this.capacity = capacity;
        this.size = 0;
        this.rows = new Row[capacity];// TODO: implement
    }

    /**
     * Returns the capacity of the table.
     */
    public int getCapacity() {
        return this.capacity; // TODO: implement
    }

    /**
     * Returns the number of rows stored in the table.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the rows stored in the table.
     */
    public Row[] getRows() {
         return this.rows; // TODO: implement
    }

    /**
     * Sets the number of rows stored in the table.
     */
    public void setSize(int size) {
        // TODO: implement
    }

    /**
     * Returns the row at the given index.
     *
     * @param index The index of the row to return.
     * @return The row at the given index or null if the index is out of bounds.
     */
    public Row getRow(int index) {
        if (index >= 0 && index < capacity) {
            return rows[index];
        }
        return null; // TODO: implement
    }

    /**
     * Sets the row at the given index.
     *
     * @param index The index of the row to set.
     * @param row The new value of the row.
     * @return true if the row was set, false otherwise, including if the index
     *   is out of bounds.
     */
    public boolean setRow(int index, Row row) {
        if (index >= 0 && index < capacity) {
            rows[index] = row;
            size++;
            return true;
        }
        return false; // TODO: implement
    }

    /**
     * Resizes the table.
     *
     * If the new size is smaller than the old size, the table is truncated,
     * i.e. all rows with an index >= capacity are deleted; if the new size
     * is larger than the old size, the table is extended by adding new rows
     * that are initialized with `null`.
     *
     * @param capacity The new capacity of the table.
     * @return The new capacity of the table.
     */
    public int resize(int newCapacity) {
        if (newCapacity < capacity) {
            size = newCapacity;
            Row[] newRows = new Row[newCapacity];
            System.arraycopy(rows, 0, newRows, 0, newCapacity);
            rows = newRows;
            capacity = newCapacity;
        } else if (newCapacity > capacity) {
            Row[] newRows = new Row[newCapacity];
            System.arraycopy(rows, 0, newRows, 0, rows.length);
            rows = newRows;
            capacity = newCapacity;
        }
        return capacity;
    }

    /**
     * Adds a row to the table.
     *
     * @param row The row to add.
     * @return true if the row was added, false otherwise, i.e. if the table
     *   is full.
     */
    public boolean addRow(Row row) {
        if (row == null || size >= capacity) {
            return false; // Return false if the row is null or table is full
        }
        rows[size++] = row;
        return true;
    }

    /**
     * Returns the maximum dimension amongst rows in the table.
     *
     * The dimension of a `null` row is 0.
     */
    public int getMaxDimension() {
        int maxDimension = 0;
        for (Row row : rows) {
            if (row != null && row.getDimension() > maxDimension) {
                maxDimension = row.getDimension();
            }
        }
        return maxDimension; // TODO: implement
    }

    /**
     * Returns the average of each row.
     *
     * Empty (i.e. NaN) values are excluded from the calculation entirely.
     *
     * @return If the table is not empty, a new array containing the
     *   average of each row or 0 if a row is `null`. If the table is empty,
     *   `null` is returned. If all entries are NaN, NaN is returned.
     */
public double[] getRowAverages() {
    if (capacity == 0) {
        return null;
    }
    double[] averages = new double[capacity];

    for (int i = 0; i < capacity; i++) {
        if (rows[i] != null && rows[i].getDimension() > 0) {
            averages[i] = rows[i].getAverage();
            }
    }
    return averages;
}

public double[] getColumnAverages() {
    int maxDimension = getMaxDimension();
        if (capacity == 0) {
            return null;
        }

        double[] averages = new double[capacity];
        double[] otvet = new double[maxDimension];

        for (int i = 0; i < maxDimension; i++) {
                for (int j = 0; j < capacity; j++) {
                    averages[j] = rows[j].getValue(i);
                }
                Row sps = new Row(capacity);
                sps.setValues(averages);
                otvet[i] = sps.getAverage();


        }

        return otvet;
}




    /**
     * Returns a string representation of the table.
     */
    @Override
    public String toString() {
        StringBuilder tableString = new StringBuilder();
        tableString.append("Table: ").append(super.getName()).append("\n");
        for (Row row : rows) {
            if (row != null) {
                tableString.append(row).append("\n");
            }
        }
        return tableString.toString();// TODO: implement
    }
    
    // Ignore this. It’s here for the tests to work properly.
    protected FixedSizeTable() {}
}