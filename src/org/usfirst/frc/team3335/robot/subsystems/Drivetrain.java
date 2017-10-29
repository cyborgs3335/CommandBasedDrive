package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.commands.DriveWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private final Talon frontLeftController = new Talon(1);
	private final Talon rearLeftController = new Talon(2);
	private final Talon frontRightController = new Talon(3);
	private final Talon rearRightController = new Talon(4);
	private final RobotDrive drivetrain;

	public Drivetrain() {
        super();
        drivetrain = new RobotDrive(frontLeftController, rearLeftController,
                frontRightController, rearRightController);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithJoystick());
	}

	public void drive(Joystick stick) {
	    drivetrain.arcadeDrive(stick, true); // Setting the second argument to true squares the input values,
                                             // which decreases sensitivity for small movements of the joystick
	}
}
