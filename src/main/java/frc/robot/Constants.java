// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
    public static class MotorConstants {
        public static int LEFT_MOTOR_ID = 0;
        public static int RIGHT_MOTOR_ID = 1;
    }

    public static class DriveConstants {
        public static int SPEED = 0;
        // public static int ACCEL = 0;
    }

    public static class Deadzone {
        public static double MIN_THROTTLE = 0.05;
        public static double MIN_TURN = 0.05;
    }
}
