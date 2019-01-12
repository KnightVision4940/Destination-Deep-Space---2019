/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //talons *these may need to change based on what the robot uses this year*
  static Victor FrontLeft;
  static Talon RearLeft;
  static Talon FrontRight;
  static Talon RearRight;

  //Our speed controllergroups for right and left 
  SpeedControllerGroup Right;
  SpeedControllerGroup Left;

  static DifferentialDrive m_drive; 
//d@nte was here
  public DriveTrain(int frontLeft, int frontRight, int backLeft, int backRight) {
    
    FrontLeft = new Victor(frontLeft);
    RearLeft = new Talon(backLeft);

    FrontRight = new Talon(frontRight);
    RearRight = new Talon(backRight);

    Left = new SpeedControllerGroup(FrontLeft, RearLeft);
    Right = new SpeedControllerGroup(FrontRight, RearRight);

    m_drive = new DifferentialDrive(Left, Right);
  }

  public static void drive(double speed, double turn){
    m_drive.arcadeDrive(speed, turn, false);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
