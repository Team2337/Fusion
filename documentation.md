```java
public class Robot extends FusionRobot {
    
}



public class FusionRobot extends TimedRobot {
    public robotInit() {
        
    }
}
public class FusionAutoChooser {
    public SendableChooser<String> chooser = new SendableChooser<>();
    public HashMap<String, Command> commands = new HashMap<String, Command>;
    public FusionAutoChooser() {

    }
    public void addAuton(String name, Command command) {
        String id = name.toLowerCase().replaceAll(" ", "_");
        chooser.addObject(name, id) //chooser.addObject("Cheesy Poofs 3 Cube", "cheesy_poofs_3_cube")
        commands.
    }
}


FusionAutoChooser autochooser = new FusionAutoChooser()
autochooser.addAuton("Cheesy Poofs 3 Cube", CheesyPoof)
autochooser.runSelected()

```

- Fusion
    - Controller
    - Commands



