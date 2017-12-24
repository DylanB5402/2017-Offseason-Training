package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;
import org.usfirst.frc.team687.robot.constants.DriveConstants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TurnPID extends Command {
	private double m_target;
	private double m_error;
	private double m_currentAngle;
	private double m_rotPower;
	
    public TurnPID(double target) {
    	m_target = target;
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_currentAngle = Robot.drive.getYaw();
    	m_error = m_target - m_currentAngle;
    	m_rotPower = m_error * DriveConstants.kRotP;
    	
    	if (m_rotPower > DriveConstants.kRotMaxPwr) {
    		m_rotPower = DriveConstants.kRotMaxPwr;
    	}
    	
    	if (m_rotPower < DriveConstants.kRotMinPwr) {
    		m_rotPower = DriveConstants.kRotMinPwr;
    	}
    	
    	Robot.drive.setPower(m_rotPower, m_rotPower);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs(m_error)< DriveConstants.kRotTolerance;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
