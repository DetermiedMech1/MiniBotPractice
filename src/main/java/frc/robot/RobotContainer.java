// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.AutoCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.subsystems.DriveTrainSubsystem;

import edu.wpi.first.wpilibj2.command.Command;

public class RobotContainer {
	private final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
	private final DriveCommand driveCommand = new DriveCommand(driveTrainSubsystem);
	private final AutoCommand autoCommand = new AutoCommand(driveTrainSubsystem);

	public RobotContainer() {
		configureButtonBindings();
	}

	private void configureButtonBindings() {}

	public Command getAutonomousCommand() {
		return autoCommand;
	}

	public Command getTeleopCommand() {
		return driveCommand;
	}
}
