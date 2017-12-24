package org.usfirst.frc.team687.robot.subsystems;

import org.usfirst.frc.team687.robot.RobotMap;

import com.ctre.phoenix.MotorControl.SmartMotorController.TalonControlMode;
import com.ctre.phoenix.MotorControl.CAN.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeRoller extends Subsystem {
	private final TalonSRX m_roller;
    // Initialize your subsystem here
	
    public IntakeRoller() {
    	m_roller = new TalonSRX(RobotMap.IntakeRoller);
    }

    public void setPower(double power) {
    	m_roller.changeControlMode(TalonControlMode.PercentVbus);
    	m_roller.set(power);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    }

