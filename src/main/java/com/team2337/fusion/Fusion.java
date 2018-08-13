package com.team2337.fusion;

import edu.wpi.first.networktables.*;

import java.awt.List;
import java.io.*;
import java.rmi.server.ServerNotActiveException;
import java.util.HashMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.team2337.fusion.tools.NT;
/**
 * Fusion is the base class which controller all data handled between other single instanced based classes
 * - Controller Manager
 * - Auton Command Manager
 * - Voltage Manager? (coming soon3)
 * 
 * <p>Most of this class in maintaied by the FusionTimedRobot which would be your Robot.java class*
 * 
 * @author Brendan (2337)
 */
public class Fusion {
	
	private static Fusion instance;
		
	private NetworkTable tableFusion, tableReactor;
	private HashMap<String, Subsystem> subsystems = new HashMap<String, Subsystem>();
	/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

	/**
	 * Returns the {@link CommandManager}, creating it if one does not exist.
	 *
	 * @return the {@link CommandManager}
	 */
	public static synchronized Fusion getInstance() {
		if (instance == null) {
			instance = new Fusion();
			
		}
		return instance;
	}
	/**
	 * buildReactor - Initalize the Fusion lib (like its reacting)
	 * 
	 *
	 * {@link com.team2337.fusion.robot.FusionTimedRobot}
	 */
	public void buildReactor() {
        this.tableFusion = NetworkTableInstance.getDefault().getTable("Fusion");
        this.tableReactor = this.tableFusion.getSubTable("Reactor");
        NT.setText(this.tableReactor, "version", FusionConstants.FUSION_VERSION);
	
        this.updateMacAddress();
    }
	/**
	 * updateMacAddress - Gets Mac Address of Robot
	 * 
	 */
    public String updateMacAddress() {
        String macAddress = "";
		this.tableReactor = NetworkTableInstance.getDefault().getTable("");
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
            
            NT.setText(this.tableReactor, "robotMacAddress",  (String) macAddress);
	        return macAddress;
		} catch (IOException e){
        	return null;
        }
	}
	public void registerSubsystem(Subsystem subsystem) {
		
	}
}


