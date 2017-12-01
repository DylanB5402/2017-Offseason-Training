package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;
import org.usfirst.frc.team687.robot.RobotMap;
import org.usfirst.frc.team687.robot.constants.DriveConstants;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {
	private double m_lTarget, m_rTarget;
	private double m_lError, m_rError;
	private double m_lticks, m_rticks;
	private double m_lpower, m_rpower;
//	private double m_starttime, m_currenttime;
//	private double m_lcurrentintegralsum, m_rcurrentintegralsum;
//	private double m_timepassed;
//	private double m_lintegralsum, m_rintegralsum;
//	private double m_lastrticks, m_lastlticks;
//	private double m_lasttime;
//	private double m_lDerivative, m_rDerivative;
	
//	ID commented out, P left alone
	
    public DriveForward(double target) {
    	m_lTarget = target;
    	m_rTarget = target;
    	requires(Robot.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.leftResetTicks();
    	Robot.drive.rightResetTicks();
//    	m_starttime = Timer.getFPGATimestamp();
//    	m_currenttime = Timer.getFPGATimestamp();
//    	m_lastlticks = 0;
//    	m_lastrticks = 0;
//    	m_lasttime = 0;
    }

    protected void execute() {
    	m_lticks = Robot.drive.getLeftPos();
    	m_rticks = Robot.drive.getRightPos();
    	m_lError = m_lTarget - m_lticks;
    	m_rError = m_rTarget - m_rticks;
    	  	    	
//    	m_timepassed = m_currenttime - m_lasttime;
//    	
//    	m_lcurrentintegralsum = ((m_lastlticks +  m_lticks) * m_timepassed)/2;
//    	m_rcurrentintegralsum = ((m_lastrticks +  m_rticks) * m_timepassed)/2;
//    	m_lintegralsum = m_lintegralsum + m_lcurrentintegralsum;
//    	m_rintegralsum = m_rintegralsum + m_rcurrentintegralsum;
//    	
//    	m_lDerivative = (m_lticks - m_lastlticks)/m_timepassed;
//    	m_rDerivative = (m_rticks - m_lastrticks)/m_timepassed;
//    			
//    	m_lpower = m_lError * DriveConstants.kForwardP + m_lintegralsum * DriveConstants.kForwardI + m_lDerivative * DriveConstants.kForwardD;
//    	m_rpower = m_rError * DriveConstants.kForwardP + m_rintegralsum * DriveConstants.kForwardI  + m_rDerivative * DriveConstants.kForwardD;
    	
    	m_lpower = m_lError * DriveConstants.kForwardP;
    	m_rpower = m_rError * DriveConstants.kForwardP;
    			
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
    	
//    	m_lastlticks = m_lticks;
//    	m_lastrticks = m_rticks;
//    	m_lasttime = m_currenttime;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       return m_lError < DriveConstants.kForwardTolerance && m_rError < DriveConstants.kForwardTolerance;        	

    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
