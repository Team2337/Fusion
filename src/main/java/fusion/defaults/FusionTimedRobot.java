package fusion.defaults;
import edu.wpi.first.hal.FRCNetComm.tInstances;
import edu.wpi.first.hal.FRCNetComm.tResourceType;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.Notifier;
import fusion.Fusion;
/**
 * FusionTimedRobot implements the FusionRobotBase robot program framewor k based upon the IterativeRobotBase.
 *
 * The FusionTimedRobot class is intended to be subclassed by a user creating a robot program.
 * 
 * Also FusionTimedRobot is used to start the Reactor Instance, making working network table API to be used
 * 
 * @author FIRST/WPI
 * @author Brendan (2337)
 */
public class FusionTimedRobot extends FusionRobotBase {
  public static final double DEFAULT_PERIOD = 0.02;

  private volatile double m_period = DEFAULT_PERIOD;

  // Prevents loop from starting if user calls setPeriod() in robotInit()
  private boolean m_startLoop = false;

  private Notifier m_loop = new Notifier(() -> {
    loopFunc();
  });

  public FusionTimedRobot() {
    // HAL.report(tResourceType.kResourceType_Framework, tInstances.kFramework_Periodic);
    HAL.report(tResourceType.kResourceType_Framework, tInstances.kFramework_Iterative);
  }

  /**
   * Provide an alternate "main loop" via startCompetition().
   */
  public void startCompetition() {
    //Builds Fusion
    Fusion.getInstance().build();
    
    
    robotInit();

    // Tell the DS that the robot is ready to be enabled
    HAL.observeUserProgramStarting();

    // Loop forever, calling the appropriate mode-dependent function
    m_startLoop = true;
    m_loop.startPeriodic(m_period);
    while (true) {
      try {
        Thread.sleep(1000 * 60 * 60 * 24);
      } catch (InterruptedException ex) {
        Thread.currentThread().interrupt();
      }
    }
  }

  /**
   * Set time period between calls to Periodic() functions.
   *
   * @param period Period in seconds.
   */
  public void setPeriod(double period) {
    m_period = period;

    if (m_startLoop) {
      m_loop.startPeriodic(m_period);
    }
  }

  /**
   * Get time period between calls to Periodic() functions.
   */
  public double getPeriod() {
    return m_period;
  }
}