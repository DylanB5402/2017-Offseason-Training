package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.OI;
import org.usfirst.frc.team687.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 Arcade drive, but throttle is controlled by right and left triggers on Xbox Controller. Left stick is for steering. 
 */
public class VideoGameDrive extends Command {

    public VideoGameDrive() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	double m_throttle = Robot.oi.xbox.getTriggerAxis(Hand.kRight) - Robot.oi.xbox.getTriggerAxis(Hand.kLeft);
    	m_throttle = Math.pow(m_throttle, 2);
    	double m_steering = Robot.oi.xbox.getRawAxis(0);
    	m_steering = Math.pow(m_steering, 2);
    	double m_leftpower = m_throttle - m_steering;
    	double m_rightpower = m_throttle + m_steering;
    	
    	if (m_leftpower > 1) {
    		m_leftpower = 1;
    	}
    	if (m_leftpower < -1) {
    		m_leftpower = -1;
    	}
    	if (m_rightpower > 1) {
    		m_rightpower = 1;
    	}
    	if (m_rightpower < -1) {
    		m_rightpower = -1;
    	}
    	Robot.drive.setPower(m_leftpower, m_rightpower);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
