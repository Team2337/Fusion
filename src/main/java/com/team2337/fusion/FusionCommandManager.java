package com.team2337.fusion;


import java.awt.List;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * FusionManager - Manager for {@link FusionSubsystem}
 * @author Brendan
 *
 */
public class FusionCommandManager {
	
	private static FusionCommandManager instance;
	private double color;
	private int id = 0;
	private int running = 0;
	public String state;
	private HashMap<Integer, CommandObject> commands = new HashMap<Integer, CommandObject>();

	private NetworkTable table;
	/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

	/**
	 * Returns the {@link CommandManager}, creating it if one does not exist.
	 *
	 * @return the {@link CommandManager}
	 */
	public static synchronized FusionCommandManager getInstance() {
		if (instance == null) {
			instance = new FusionCommandManager();
			
		}
		return instance;
	}
	/**
	 * init - Initalize of AutoCommandManager (in Robot)
	 */
	public void init() {
		this.table = NetworkTableInstance.getDefault().getTable("Fusion/Subsystems");
		
	}
	
	//Methods for AutoCommand to run
	/**
	 * init - Where the command start, send name, time started etc
	 * @param name Name of the command
	 * @return id ID given to the command
	 */
	public int init(String name, int type) {
		String colors;
		
		NetworkTableEntry data = table.getEntry(id + "_");		
		String[] info = {name, colors, String.valueOf(object.startTime.toInstant(ZoneOffset.ofHours(-5)).getEpochSecond())};
		data.forceSetStringArray(info);
		return id;
	}
	public void end(String name, int id) {
		this.running = -1;
		AutoObject object = commands.get(id);
		object.stopTime();
		double endTime = object.getTime();
		String et = endTime + "";
		String[] info = {object.commandName, object.color, String.valueOf(object.startTime.toInstant(ZoneOffset.ofHours(-5)).getEpochSecond()), et};
		NetworkTableEntry data = table.getEntry(id + "_");
		data.forceSetStringArray(info);
	}
}
