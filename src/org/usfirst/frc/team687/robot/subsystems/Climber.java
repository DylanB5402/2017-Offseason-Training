package org.usfirst.frc.team687.robot.subsystems;

import org.usfirst.frc.team687.robot.RobotMap;

import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    private final TalonSRX climberTalon;
	
    public Climber() {
    	climberTalon = new TalonSRX(RobotMap.ClimberTalon);
    }
    
    public void setPower(double power) {
    	climberTalon.set(power);
    }
    
    public void initDefaultCommand() {
        
    }
}

