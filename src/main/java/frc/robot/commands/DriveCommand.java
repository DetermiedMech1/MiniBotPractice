// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;

import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

import edu.wpi.first.wpilibj.XboxController;

public class DriveCommand extends CommandBase {
	@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
	private final DriveTrainSubsystem driveTrain;
	private XboxController controller;
	private double throttle, turn;

	public DriveCommand(DriveTrainSubsystem dt) {
		driveTrain = dt;
		addRequirements(dt);
	}

	@Override
	public void initialize() {
		controller = new XboxController(0);
	}

	@Override
	public void execute() {
		// update controller values
		throttle = -controller.getLeftY();
		turn = controller.getRightX();

		// set to 0 if in deadzone
		if (Math.abs(throttle) - Constants.Deadzone.MIN_THROTTLE < 0) throttle = 0;
		if (Math.abs(turn) - Constants.Deadzone.MIN_TURN < 0) turn = 0;

		// drive!
		driveTrain.manualDrive(throttle, turn);
	}

	@Override
	public void end(boolean interrupted) {}

	@Override
	public boolean isFinished() {
		return false;
	}
}
