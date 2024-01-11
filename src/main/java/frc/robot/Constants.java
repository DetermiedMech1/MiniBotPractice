// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class MotorConstants
    {
        public static int LEFT_MOTOR_ID = 0;
        public static int RIGHT_MOTOR_ID = 1;
    }

    public static class DriveConstants
    {
        public static double SPEED = 0.5;
        public static final double kTrackingP = 0.03; // 0.02
        public static final double kTrackingI = 0.0; // 0.003
        public static final double kTrackingD = 0.02; // 0.001
    }

    public static class DeadZone
    {
        public static double THROTTLE_DEADZONE = -0.3;
        public static double TURN_MAX_DEADZONE = 0.3;
        public static double TURN_MIN_DEADZONE = -TURN_MAX_DEADZONE;
    }

    public static class LimelightConstants {
        public static final double kLLHeight = Units.inchesToMeters(24.5);
        public static final double kLLPitch = Units.degreesToRadians(0);
        public static final double kMinObjectAvoidanceDistance = Units.inchesToMeters(12);
        public static final double kObjectHeight = Units.inchesToMeters(12);
        public static final double kObjectPitch = Units.degreesToRadians(0);

        public static final int[] kBlueAprilTags = new int[]{1,2,3,4};
        public static final int[] kRedAprilTags = new int[]{5,6,7,8};
    }
}
