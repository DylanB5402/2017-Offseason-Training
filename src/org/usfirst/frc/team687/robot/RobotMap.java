package org.usfirst.frc.team687.robot;

import com.ctre.phoenix.MotorControl.CAN.TalonSRX;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	public static int MasterRightTalon1 =1;
	public static int SlaveRightTalon2 =2;
	public static int SlaveRightTalon3 =3;
	public static int MasterLeftTalon1 =4;
	public static int SlaveLeftTalon2 =5;
	public static int SlaveLeftTalon3 =6;
	
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
}
