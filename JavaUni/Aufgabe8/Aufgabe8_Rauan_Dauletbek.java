//Rauan Dauletbek, 12337766
package einfprog;
import java.util.Arrays;
import java.util.List;

public class Bsp08 {
  public static void main(String[] args) {
    Row row = new Row(5);
        System.out.println("Dimension: " + row.getDimension());
        System.out.println("Values: " + Arrays.toString(row.getValues()));
        row.setValue(2, 10.5);
        row.setValue(4, 20.7);
        System.out.println("Value at index 2: " + row.getValue(2));
        System.out.println("Set value at index 3: " + row.setValue(3, 15.3));
        System.out.println("Average: " + row.getAverage());
        System.out.println("Row: " + row);

        // Test Table class
        Table table = new Table("MyTable");
        System.out.println("Table name: " + table.getName());
        table.setName("NewTable");
        System.out.println("Updated table name: " + table.getName());
        System.out.println("Table: " + table);

        // Test FixedSizeTable class
        FixedSizeTable fixedSizeTable = new FixedSizeTable("FixedSize", 3);
        System.out.println("FixedSizeTable capacity: " + fixedSizeTable.getCapacity());
        System.out.println("FixedSizeTable size: " + fixedSizeTable.getSize());
        Row row1 = new Row(2);
        Row row2 = new Row(3);
        row1.setValues(new double[]{1.2, 2.3});
        row2.setValues(new double[]{3.4, 4.5, 5.6});
        fixedSizeTable.addRow(row1);
        fixedSizeTable.addRow(row2);
        System.out.println("Updated FixedSizeTable size: " + fixedSizeTable.getSize());
        System.out.println("FixedSizeTable rows: " + Arrays.toString(fixedSizeTable.getRows()));
        System.out.println("Max dimension: " + fixedSizeTable.getMaxDimension());
        System.out.println("Row averages: " + Arrays.toString(fixedSizeTable.getRowAverages()));
        System.out.println("Column averages: " + Arrays.toString(fixedSizeTable.getColumnAverages()));
        System.out.println("Resized FixedSizeTable capacity: " + fixedSizeTable.resize(5));
        System.out.println("FixedSizeTable: " + fixedSizeTable);
    }
}