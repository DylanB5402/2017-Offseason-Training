package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;
import org.usfirst.frc.team687.robot.RobotMap;
import org.usfirst.frc.team687.robot.constants.DriveConstants;

import com.ctre.phoenix.MotorControl.CAN.TalonSRX;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {
	private double m_ltarget, m_rtarget;
	private double m_lerror, m_rerror;
	private double m_lticks, m_rticks;
	private double m_lpower, m_rpower;
	private final TalonSRX m_rMasterTalon, m_lMasterTalon;
	
    public DriveForward() {
    	m_rMasterTalon = new TalonSRX(RobotMap.MasterRightTalon1);
    	m_lMasterTalon = new TalonSRX(RobotMap.MasterLeftTalon1);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	m_rMasterTalon.reset();
    	m_lMasterTalon.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_lticks = Robot.drive.getLeftPos();
    	m_rticks = Robot.drive.getRightPos();;
    	
    	m_lerror = m_ltarget - m_lticks;
    	m_rerror = m_rtarget - m_rticks;
    	m_lpower = m_lerror * DriveConstants.kForwardP;
    	m_rpower = m_rerror * DriveConstants.kForwardP;
    	
    	if (m_lpower > DriveConstants.kForwardMaxPwr) {
    		m_lpower = DriveConstants.kForwardMaxPwr;    				
    	}
    	if (m_rpower > DriveConstants.kForwardMaxPwr) {
    		m_rpower = DriveConstants.kForwardMaxPwr;    				
    	}
    	if (m_lpower < DriveConstants.kForwardMinPwr) {
    		m_lpower = DriveConstants.kForwardMinPwr;    				
    	}
    	if (m_rpower < DriveConstants.kForwardMinPwr) {
    		m_rpower = DriveConstants.kForwardMinPwr;    				
    	}
    	Robot.drive.setPower(m_lpower, -m_rpower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       return m_lerror < DriveConstants.kForwardTolerance && m_rerror < DriveConstants.kForwardTolerance;        	

    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
