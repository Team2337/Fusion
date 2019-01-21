package fusion.tools;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * FusedNT is a small library that allows for setting NT Tables (and sub-tables)
 * 
 * @author Brendan F.
 */
public class FusedNT {
    // Prevent this class from being recreated
    private FusedNT() {
    }

    /**
     * Sets an entry of a NetworkTable to have a STRING value
     * 
     * @param table The table being selected
     * @param id    The entry in the table
     * @param value The string value to set
     */
    public static void setText(NetworkTable table, String id, String value) {
        NetworkTableEntry e = table.getEntry(id);
        e.forceSetString(value);
    }

    /**
     * Sets an entry of a NetworkTable to have a NUMBER value
     * 
     * @param table The table being selected
     * @param id    The entry in the table
     * @param value The decimal number value
     */
    public static void setNumber(NetworkTable table, String id, double value) {
        NetworkTableEntry e = table.getEntry(id);
        e.forceSetDouble(value);
    }
}
