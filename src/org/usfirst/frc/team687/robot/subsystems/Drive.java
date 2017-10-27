package org.usfirst.frc.team687.robot.subsystems;

import org.usfirst.frc.team687.robot.RobotMap;
import org.usfirst.frc.team687.robot.commands.TankDrive;

import com.ctre.phoenix.MotorControl.CAN.TalonSRX;
import com.ctre.phoenix.MotorControl.SmartMotorController.TalonControlMode;

import edu.wpi.first.wpilibj.command.Subsystem;

//Replace all TalonSRXs with CTRE TalonSRX
public class Drive extends Subsystem {
    private final TalonSRX m_lMasterTalon, m_leftTal2, m_leftTal3;
    private final TalonSRX m_rMasterTalon, m_rightTal2, m_rightTal3;
    
    public Drive() {
    	m_lMasterTalon = new TalonSRX(RobotMap.MasterLeftTalon1);
    	m_leftTal2 = new TalonSRX(RobotMap.SlaveLeftTalon2);
    	m_leftTal3 = new TalonSRX(RobotMap.SlaveLeftTalon3);
    	m_rMasterTalon = new TalonSRX(RobotMap.MasterRightTalon1);
    	m_rightTal2 = new TalonSRX(RobotMap.SlaveRightTalon2);
    	m_rightTal3 = new TalonSRX(RobotMap.SlaveRightTalon3);

		m_lMasterTalon.setFeedbackDevice(TalonSRX.FeedbackDevice.CtreMagEncoder_Relative);
		m_rMasterTalon.setFeedbackDevice(TalonSRX.FeedbackDevice.CtreMagEncoder_Relative);
    }
    
    public void setPower(double leftPower, double rightPower) {
    	m_lMasterTalon.changeControlMode(TalonControlMode.PercentVbus);
    	m_leftTal2.changeControlMode(TalonControlMode.PercentVbus);
    	m_leftTal3.changeControlMode(TalonControlMode.PercentVbus);
    	m_rMasterTalon.changeControlMode(TalonControlMode.PercentVbus);
    	m_rightTal2.changeControlMode(TalonControlMode.PercentVbus);
    	m_rightTal3.changeControlMode(TalonControlMode.PercentVbus);
	
    	m_lMasterTalon.set(leftPower);
    	m_leftTal2.set(leftPower);
    	m_leftTal3.set(leftPower);
    	m_rMasterTalon.set(rightPower);
    	m_rightTal2.set(rightPower);
    	m_rightTal3.set(rightPower);    	
    }
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public double getLeftPos() {
    	return m_lMasterTalon.getEncPosition();
    }
    
    public double getRightPos() {
    	return m_rMasterTalon.getEncPosition();
    }
    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

