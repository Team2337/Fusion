package fusion;

import java.util.HashMap;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import fusion.defaults.FusionCommandObject;


/**
 * FusionCommandManager -> Manages Commands for the Robot.
 * 
 * @author Brendan F.
 * @author Bryce G.
 */
public class FusionCommandManager {

	private static FusionCommandManager instance;
	private HashMap<Integer, FusionCommandObject> commands = new HashMap<Integer, FusionCommandObject>();

	private NetworkTable commandTable;
	private int commandAmount = 0;
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
	 * Starts the command manager initilization period
	 */
	public void start() {
		//Get the table and subtable (single line version)
		this.commandTable = NetworkTableInstance.getDefault().getTable("Fusion/Commands/");
	}

	// Methods for AutoCommand to run
	/**
	 * init {@see FusionCommand# }
	 * 
	 * @param command   Name of the command running
	 * @param subsystem Subsystem of the command running
	 * @return id Identifier of the Command
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
			 * command: command running subsystems: subsystem the command is running from
			 * mode: mode the robot is in (ie telepo or auton)
			 * commandObject.getStartEpoch(): the unix time stamp timer start
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
		//Check if fusion is running, if so we can update Network Tables
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