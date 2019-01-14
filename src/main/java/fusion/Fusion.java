package fusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import fusion.tools.FusedNT;
import fusion.FusionCommandManager;

/**
 * Fusion (Singleton)
 * 
 * Main runtime is this class.
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
     * Fusion (singleton)
     * @return
     */
    public static synchronized Fusion getInstance() {
        if (instance == null) {
            instance = new Fusion();
        }
        return instance;
    }

    /**
     * build - This is the startup process of Fusion. We buid it, like a robot.
     */
    public void build() {
        System.out.println("[FUSION] Starting up! (ver " + FusionConstants.FUSION_VERSION + ")");

        // Make the Tables and Subtables of Fusion
        this.tableFusion = NetworkTableInstance.getDefault().getTable("Fusion");
        this.tableCore = this.tableFusion.getSubTable("Core");
        FusedNT.setText(this.tableCore, "version", FusionConstants.FUSION_VERSION);

        // Save the mac address
        this.macAddress = this.updateMacAddress();
        System.out.println("[FUSION] Robot Mac: " + this.macAddress);

        // Start other managers
        FusionCommandManager.getInstance().start();

        // Disable Fusion when connected to the Field (FMS)
        if (DriverStation.getInstance().isFMSAttached()) {
            this.running = false;
        }
    }

    /**
     * Returns the FusionCommandManager
     * 
     * @return
     */
    public FusionCommandManager command() {
        return FusionCommandManager.getInstance();
    }

    /**
     * Sets the current mode of the robot
     * 
     * @param mode
     */
    public void setMode(String mode) {
        this.mode = mode;
    }

    /**
     * Gets the current mode the robot is in
     */
    public String getMode() {
        return this.mode;
    }

    /**
     * This will enable Fusion
     */
    public void enable() {
        this.running = true;
    }

    /**
     * This wll disable Fusion
     */
    public void disable() {
        this.running = false;
    }

    /**
     * updateMacAddress - Get the robots mac address. Useful if a practice bot has
     * different settings that a compbot.
     * 
     * @return String [mac]
     */
    public String updateMacAddress() {
        String macAddress = "";
        try {
            Process pid = Runtime.getRuntime().exec("/home/admin/getAddr");
            BufferedReader in = new BufferedReader(new InputStreamReader(pid.getInputStream()));
            String s;
            while ((s = in.readLine()) != null) {
                macAddress = s;
                System.out.println(s + " -");
                break;
            }
            System.out.println(macAddress);
            in.close();

            FusedNT.setText(this.tableCore, "robotMacAddress", (String) macAddress);
            return macAddress;
        } catch (IOException e) {
            return null;
        }
    }
}