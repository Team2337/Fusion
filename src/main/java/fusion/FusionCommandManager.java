package fusion;

import java.util.HashMap;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import fusion.defaults.FusionCommandObject;

/**
 * Manages Commands for the Robot. //Improve? Be more specific
 * 
 * @author Brendan F.
 * @author Bryce G.
 */
public class FusionCommandManager {

	// At each robot startup, create a statically accessible version of the manager
	private static FusionCommandManager instance;

	// This HashMap holds the data for accessing the commands' runtime information
	private HashMap<Integer, FusionCommandObject> commands = new HashMap<Integer, FusionCommandObject>();

	// Declares the NetworkTable object that will keep track of all the data
	private NetworkTable commandTable;

	// The total amount of FusionCommands created (used to keep track of IDs)
	private int commandAmount = 0;
	/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/

	/**
	 * Returns the CommandManager, creating it if one does not exist.
	 *
	 * @return The instance of the command manager, which can be used to get various
	 *         pieces of information
	 */
	public static synchronized FusionCommandManager getInstance() {
		if (instance == null) {
			instance = new FusionCommandManager();
		}
		return instance;
	}

	/**
	 * Starts the CommandManager
	 */
	public void start() {
		// Points towards the NetworkTables entry storing all the commands' information
		this.commandTable = NetworkTableInstance.getDefault().getTable("Fusion/Commands/");
	}

	/**
	 * Initializes the command
	 * 
	 * @param command   Name of the command running
	 * @param subsystem Subsystem of the command running
	 * @return The ID of the Command
	 */
	public int init(String command, String subsystem) {
		if (Fusion.getInstance().running) {
			String mode = Fusion.getInstance().getMode();
			NetworkTableEntry entry = this.commandTable.getEntry(this.commandAmount + "_");

			FusionCommandObject commandObject = new FusionCommandObject();
			commands.put(this.commandAmount, commandObject);

			/**
			 * Array containing the information of the command that is running
			 * 
			 * command: The command that's being run subsystem: The subsystem the command is
			 * running from mode: The mode the robot is in (IE: teleop or auton)
			 * commandObject.getStartEpoch(): Gets the start time of the command
			 */
			String[] info = { command, subsystem, mode, commandObject.getStartEpoch() };
			entry.forceSetStringArray(info);

			int id = this.commandAmount;
			this.commandAmount++;
			return id;
		} else {
			return 0;
		}

	}

	/**
	 * This function runs code after the command has ended.
	 * 
	 * @param name      Name of command running
	 * @param subsystem Subsystem of the command running
	 * @param id        Number of the command running
	 */
	public void end(String name, String subsystem, int id) {
		// Check if fusion is running, if so we can update Network Tables
		if (Fusion.getInstance().running) {
			String mode = Fusion.getInstance().getMode();
			FusionCommandObject commandObject = commands.get(id);

			commandObject.stopTime();
			String endTime = commandObject.getTime() + "";

			String[] info = { name, subsystem, mode, commandObject.getStartEpoch(), endTime };
			NetworkTableEntry data = this.commandTable.getEntry(id + "_");
			data.forceSetStringArray(info);
		}
	}
}