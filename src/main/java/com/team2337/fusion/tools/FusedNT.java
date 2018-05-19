package com.team2337.fusion.tools;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;

/**
 * NT class is a small library that allows for setting NT Tables (and sub tables)
 * 
 * @author Brendan (2337)
 */
public class NT {
    /** Prevent this class from being instantiated. */
    private NT() {
    }
    public static void setText(NetworkTable table, String id, String value) {
        NetworkTableEntry e = table.getEntry(id);
        e.forceSetString(value);
    }
}
