package fusion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
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

    private NetworkTable tableFusion, tableCore;
    private HashMap<String, Command> subsystems = new HashMap<String, Command>();

    private static String mode;
    /**
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
     * Returns the FusionCommandManager
     * @return
     */
    public FusionCommandManager command() {
        return FusionCommandManager.getInstance();
    }
    /**
     * Sets the current mode of the robot
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

    public void build() {
        this.tableFusion = NetworkTableInstance.getDefault().getTable("Fusion");
        this.tableCore = this.tableFusion.getSubTable("Core");
        FusedNT.setText(this.tableCore, "version", FusionConstants.FUSION_VERSION);
        this.updateMacAddress();

        // Start other managers
        FusionCommandManager.getInstance().start();
    }
    public String updateMacAddress() {
        String macAddress = "";
		this.tableCore = NetworkTableInstance.getDefault().getTable("");
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
            
            FusedNT.setText(this.tableCore, "robotMacAddress",  (String) macAddress);
	        return macAddress;
		} catch (IOException e){
        	return null;
        } 
    }
}