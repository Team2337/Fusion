package fusion.tools;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * NT class is a small library that allows for setting NT Tables (and sub tables)
 * 
 * @author Brendan F.
 */
public class FusedNT {
    /** Prevent this class from being instantiated. */
    private FusedNT() {}
    /**
     * SetNumber - Sets a string to an entry of a networktable
     * @param table The table being selected
     * @param id The entry in the table
     * @param value The string value
     */
    public static void setText(NetworkTable table, String id, String value) {
        NetworkTableEntry e = table.getEntry(id);
        e.forceSetString(value);
    }
    /**
     * SetNumber - Sets a number to an entry of a networktable
     * @param table The table being selected
     * @param id The entry in the table
     * @param value The number value
     */
    public static void setNumber(NetworkTable table, String id, double value) {
        NetworkTableEntry e = table.getEntry(id);
        e.forceSetDouble(value);
    }
}
