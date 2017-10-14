package org.usfirst.frc.team687.robot.subsystems;

import org.usfirst.frc.team687.robot.RobotMap;
import org.usfirst.frc.team687.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    private final CANTalon m_leftTal1, m_leftTal2, m_leftTal3;
    private final CANTalon m_rightTal1, m_rightTal2, m_rightTal3;
    
    public Drive() {
    	m_leftTal1 = new CANTalon(RobotMap.LeftTalon1);
    	m_leftTal2 = new CANTalon(RobotMap.LeftTalon2);
    	m_leftTal3 = new CANTalon(RobotMap.LeftTalon3);
    	m_rightTal1 = new CANTalon(RobotMap.RightTalon1);
    	m_rightTal2 = new CANTalon(RobotMap.RightTalon2);
    	m_rightTal3 = new CANTalon(RobotMap.RightTalon3);        	
    }
    
    public void setPower(double leftPower, double rightPower) {
    	m_leftTal1.set(leftPower);
    	m_leftTal2.set(leftPower);
    	m_leftTal3.set(leftPower);
    	m_rightTal1.set(rightPower);
    	m_rightTal2.set(rightPower);
    	m_rightTal3.set(rightPower);    	
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

