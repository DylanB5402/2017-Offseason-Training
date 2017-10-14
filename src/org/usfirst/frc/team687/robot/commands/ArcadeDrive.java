package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ArcadeDrive extends Command {

    public ArcadeDrive() {
    	requires(Robot.drive);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double leftpower = Robot.oi.lStick.getY() - Robot.oi.rStick.getX();
    	double rightpower = Robot.oi.lStick.getY() + Robot.oi.rStick.getX();
    	if (leftpower > 1) {
    		leftpower = 1;
    	}
    	if (leftpower < -1) {
    		leftpower = -1;
    	}
    	if (rightpower > 1) {
    		rightpower = 1;
    	}
    	if (rightpower < -1) {
    		rightpower = -1;
    	}
    	Robot.drive.setPower(leftpower, rightpower);
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
