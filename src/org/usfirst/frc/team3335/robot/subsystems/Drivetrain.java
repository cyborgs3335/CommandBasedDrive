package org.usfirst.frc.team3335.robot.subsystems;

import org.usfirst.frc.team3335.robot.commands.DriveWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	private final WPI_TalonSRX frontLeftController = new WPI_TalonSRX(1);
	private final WPI_TalonSRX rearLeftController = new WPI_TalonSRX(2);
	private final WPI_TalonSRX frontRightController = new WPI_TalonSRX(3);
	private final WPI_TalonSRX rearRightController = new WPI_TalonSRX(4);
	
	private final DifferentialDrive drivetrain;

	public Drivetrain() {
        super();
        SpeedControllerGroup leftgroup = new SpeedControllerGroup(frontLeftController, rearLeftController);
        SpeedControllerGroup rightgroup = new SpeedControllerGroup(frontRightController, rearRightController);
        drivetrain = new DifferentialDrive(leftgroup, rightgroup);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithJoystick());
	}

	public void drive(Joystick stick) {
	    drivetrain.arcadeDrive(stick.getRawAxis(1), stick.getRawAxis(0) , true); // Setting the second argument to true squares the input values,
                                             // which decreases sensitivity for small movements of the joystick
	}
}
