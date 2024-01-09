// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveSubsystem extends SubsystemBase {
  public WPI_VictorSPX leftMotor, rightMotor;
  public DifferentialDrive differentialDrive;
  
  public DriveSubsystem() {
    leftMotor = new WPI_VictorSPX(Constants.MotorConstants.LEFT_MOTOR_ID);
    rightMotor = new WPI_VictorSPX(Constants.MotorConstants.RIGHT_MOTOR_ID);
    differentialDrive = new DifferentialDrive(leftMotor, rightMotor);

    leftMotor.configOpenloopRamp(0.25);
    rightMotor.configOpenloopRamp(0.25);

    leftMotor.enableVoltageCompensation(true);
    rightMotor.enableVoltageCompensation(true);

    leftMotor.setInverted(true);
    rightMotor.setInverted(false);

  }

  public void manualDrive(double throttle, double turn) {
    differentialDrive.arcadeDrive(throttle, turn);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
