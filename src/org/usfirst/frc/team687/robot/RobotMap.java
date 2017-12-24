package org.usfirst.frc.team687.robot;

import com.ctre.phoenix.MotorControl.CAN.TalonSRX;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
//	All CANTalons	
	
	public static int MasterRightTalon1 = 1;
	public static int SlaveRightTalon2 = 2;
	public static int SlaveRightTalon3 = 3;
	public static int MasterLeftTalon1 = 4;
	public static int SlaveLeftTalon2 = 5;
	public static int SlaveLeftTalon3 = 6;
	
	public static int IntakeRoller = 7;
	public static int IntakeArtic = 8;
	
	public static int ClimberTalon = 9;

}
