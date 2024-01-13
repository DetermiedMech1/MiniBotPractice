// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.XboxController;
import static frc.robot.Constants.DeadZone;

/** A Command that drives the robot using input from an XboxController.*/
public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_subsystem;
  
  private XboxController controller;
  private double throttle, turn;

  /**
   * Creates a new DriveCommand.
   *
   * @param subsystem The Drive Subsystem used by this command.
   */
  public DriveCommand(DriveSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    controller = new XboxController(0);  
    throttle = turn = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    throttle = Math.abs(controller.getLeftY()) > DeadZone.THROTTLE_DEADZONE ? -controller.getLeftY() : 0; 
    turn = Math.abs(controller.getRightX()) > DeadZone.TURN_DEADZONE ? controller.getRightX() : 0;
    m_subsystem.manualDrive(throttle, turn);
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
