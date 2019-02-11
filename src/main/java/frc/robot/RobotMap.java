/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  //Wheels
  public static int frontLeft = 1;
  public static int backLeft = 2;

  public static int frontRight = 1;
  public static int backRight = 3;

  //Arm
  public static int rotatePlate = 4;
  public static int armBase = 5;
  public static int armElbow = 6;
  public static int armWrist = 7;

  //Intake System
  public static int leftRoller = 0;
  public static int rightRoller = 9;

  //Hatch
  public static int rightHatch = 10;
  public static int leftHatch = 11;

  //Turn Table
  public static int TurnTable = 12;
  

  //Climb
  public static int climbmotor = 13;

}
