// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class AutoCommand extends CommandBase {
	@SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
	private final DriveTrainSubsystem driveTrain;

    private double startTime;

	public AutoCommand(DriveTrainSubsystem dt) {
		driveTrain = dt;
		addRequirements(dt);
	}

	@Override
	public void initialize() {
        startTime = Timer.getFPGATimestamp();
    }

	@Override
	public void execute() {
		System.out.println("a");
		driveTrain.manualDrive(0, 0.5);
	}

	@Override
	public void end(boolean interrupted) {}

	@Override
	public boolean isFinished() {
		boolean a = (Timer.getFPGATimestamp() - startTime) >= 3;
        System.out.println(a);
		return a;
	}
}
