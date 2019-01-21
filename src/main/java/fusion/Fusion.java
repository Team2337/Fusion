package fusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobotBase;
import edu.wpi.first.wpilibj.RobotBase;
import fusion.tools.FusedNT;
import fusion.FusionCommandManager;

/**
 * Fusion (Singleton)
 * 
 * This is fusion's main hub. Allowing for static access across All commands and
 * etc. It can be used for anything really, and has a purpose of keeping track
 * if Fusion should run and starting other singletons, like Command Manager
 * 
 * @author Brendan F. (@ImportProgram)
 * @author Bryce G.
 */
public class Fusion {
    private static Fusion instance;

    public String macAddress;
    public boolean running = true;
    private NetworkTable tableFusion, tableCore;
    private String mode;

    /**
     * Fusion (singleton) /////////////// What does this mean and what is it
     * returning?
     * 
     * @return
     */
    public static synchronized Fusion getInstance() {
        if (instance == null) {
            instance = new Fusion();
        }
        return instance;
    }

    /**
     * build - This is the startup process of Fusion. We build it, like a robot.
     * /////////////// What does this mean?
     */
    public void build() {
        System.out.println("[FUSION] Starting up! (Version #: " + FusionConstants.FUSION_VERSION + ")");

        // Make the Tables and Subtables of Fusion
        this.tableFusion = NetworkTableInstance.getDefault().getTable("Fusion");
        this.tableCore = this.tableFusion.getSubTable("Core");
        FusedNT.setText(this.tableCore, "version", FusionConstants.FUSION_VERSION);

        // Set the MAC address
        this.macAddress = this.updateMacAddress();
        System.out.println("[FUSION] Robot MAC Address: " + this.macAddress);

        // Start other managers
        FusionCommandManager.getInstance().start();

        // Disable Fusion when connected to a competition field (FMS)
        if (DriverStation.getInstance().isFMSAttached()) {
            System.out.println("[FUSION] CONNECTED TO FMS - DISABLING FUSION");
            this.running = false;
        }
    }

    /**
     * Returns the FusionCommandManager instance
     * 
     * @return Instance of the Fusion Command Manager
     */
    public FusionCommandManager command() {
        return FusionCommandManager.getInstance();
    }

    /**
     * Sets the current mode of the robot (EX: teleop)
     * 
     * @param mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gets the current mode the robot is in (EX: teleop)
     */
    public String getMode() {
        return this.mode;
    }

    /**
     * Enables Fusion
     */
    public void enable() {
        this.running = true;
    }

    /**
     * Disables Fusion
     */
    public void disable() {
        this.running = false;
    }

    /**
     * Get the robots MAC address. Useful if a practice robot has different settings
     * than a competition robot.
     * 
     * @return String (The MAC address)
     */
    public String updateMacAddress() {
        String macAddress = "";
        try {
            // Starts a linux program on the RoboRIO to get the MAC address
            Process pid = Runtime.getRuntime().exec("/home/admin/getAddr");
            // Reads the process's output
            BufferedReader in = new BufferedReader(new InputStreamReader(pid.getInputStream()));
            // Waits until the program has returned the address, then
            while ((macAddress = in.readLine()) != null) {
                // Once the address is returned, break from the while loop
                break;
            }
            System.out.println("Robot's MAC address: " + macAddress);
            // Stops the process reader to free up the CPU
            in.close();

            // Puts the MAC address in NetworkTables
            FusedNT.setText(this.tableCore, "robotMacAddress", (String) macAddress);
            // Return the MAC address as a string
            return macAddress;

            // If the process cannot be started or read from, return null
        } catch (IOException e) {
            return null;
        }
    }
}
