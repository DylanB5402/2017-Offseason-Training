package org.usfirst.frc.team687.robot;

import org.usfirst.frc.team687.robot.commands.SetClimberPower;
import org.usfirst.frc.team687.robot.commands.SetIntakePos;
import org.usfirst.frc.team687.robot.commands.SetRollerPower;
import org.usfirst.frc.team687.robot.constants.IntakeConstants;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Joystick lStick = new Joystick(0);
	public Joystick rStick = new Joystick(1);
	public XboxController xbox = new XboxController(2);
	public JoystickButton rollerButton;
	public JoystickButton intakeUpButton;
	public JoystickButton climberButton;
	
	public OI(){
		rollerButton = new JoystickButton(lStick, 0);		
		rollerButton.whileHeld(new SetRollerPower());
		
		intakeUpButton = new JoystickButton(lStick, 2);
		intakeUpButton.toggleWhenPressed(new SetIntakePos(IntakeConstants.kIntakeUpPos));
		
		climberButton = new JoystickButton(lStick, 3);
		climberButton.whileHeld(new SetClimberPower());
		
	}
}

