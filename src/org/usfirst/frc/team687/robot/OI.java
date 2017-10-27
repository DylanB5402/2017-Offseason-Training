package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick lStick = new Joystick(0);
	public Joystick rStick = new Joystick(1);
	public XboxController xbox = new XboxController(2);

}

