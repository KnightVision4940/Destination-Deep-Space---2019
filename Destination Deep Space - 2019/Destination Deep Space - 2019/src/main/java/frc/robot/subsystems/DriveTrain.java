/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //We are victors this year
  static Victor FrontLeft;
//  static Victor RearLeft;
  static Victor FrontRight;
//  static Victor RearRight;
static Encoder enc1;
static Encoder enc2;
static Encoder enc3;
static Encoder enc4;

  //Our speed controllergroups for right and left 
  SpeedControllerGroup Right;
  SpeedControllerGroup Left;

  static DifferentialDrive m_drive; 
//d@nte was here
  public DriveTrain(int frontLeft, int frontRight, int backLeft, int backRight) {
    
    enc1 = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
    enc2 = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
    //enc3 = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
    //enc4 = new Encoder(6, 7, false, Encoder.EncodingType.k4X);
    FrontLeft = new Victor(frontLeft);
   // RearLeft = new Victor(backLeft);
    FrontRight = new Victor(frontRight);
   // RearRight = new Victor(backRight);

   // Left = new SpeedControllerGroup(FrontLeft);
    //Right = new SpeedControllerGroup(FrontRight);

    m_drive = new DifferentialDrive(FrontLeft, FrontRight);
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
