package org.usfirst.frc.team687.robot.subsystems;

import org.usfirst.frc.team687.robot.RobotMap;

import com.ctre.phoenix.MotorControl.SmartMotorController.TalonControlMode;
import com.ctre.phoenix.MotorControl.CAN.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {
	
    private final TalonSRX m_artic;
	
    public Intake() {
    	m_artic = new TalonSRX(RobotMap.IntakeArtic);
    	m_artic.setFeedbackDevice(TalonSRX.FeedbackDevice.CtreMagEncoder_Absolute);
    }
    
    public void setPower(double power){
    	m_artic.changeControlMode(TalonControlMode.PercentVbus);
    	m_artic.set(power);
    }
    
    public double getPos() {
    	return m_artic.getEncPosition();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

