// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimeLight;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.DriveConstants;

/** A Command that autonomously guides the robot using LimeLight tracking. */
public class AutoCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_drivesystem;
  private final LimeLight m_limelight;
  private PIDController tracker;
  
  private double turn;

  /**
   * Creates a new AutoCommand.
   *
   * @param subsystem The Drive Subsystem used by this command.
   * @param limelight The LimeLight Subsystem used by this command.
   */
  public AutoCommand(DriveSubsystem subsystem, LimeLight limelight) {
    m_drivesystem = subsystem;
    m_limelight = limelight;
    tracker = new PIDController(DriveConstants.kTrackingP, DriveConstants.kTrackingI, DriveConstants.kTrackingD);
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
    addRequirements(limelight);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    turn = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
/*    turn = m_limelight.getXAngle();
    turn = MathUtil.clamp(turn/39, -1f, 1f);
    m_drivesystem.manualDrive(0, turn);*/
    if (m_limelight.getXAngle() != 0)
      turn = tracker.calculate(m_limelight.getXAngle(), 0);
    else
      turn = 0;
    m_drivesystem.manualDrive(0, -turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
