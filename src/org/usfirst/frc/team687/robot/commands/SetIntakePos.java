package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;
import org.usfirst.frc.team687.robot.constants.IntakeConstants;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetIntakePos extends Command {
	
	private double m_error;
	private double m_target;
	private double m_currentPos;
	private double m_power;
    public SetIntakePos(double target) {
    	target = m_target;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	m_currentPos = Robot.intake.getPos();
    	m_error = m_target - m_currentPos;
    	m_power = m_error*IntakeConstants.kIntakeP;
    	Robot.intake.setPower(m_power);
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
