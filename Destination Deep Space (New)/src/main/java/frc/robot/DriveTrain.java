/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
//import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;;

/**
 * Add your docs here.
 */
public class DriveTrain {
     // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //We are victors this year
  static VictorSPX FrontLeft;
  //  static Victor RearLeft;
    static VictorSPX FrontRight;
  //  static Victor RearRight;
  static Encoder enc1;
  static Encoder enc2;
  static Encoder enc3;
  static Encoder enc4;
  
    //Our speed controllergroups for right and left 
    SpeedControllerGroup Right;
    SpeedControllerGroup Left;

    public static int count;
  
    static DifferentialDrive m_drive; 
  //d@nte was here
    public DriveTrain(int frontLeft, int frontRight, int backLeft, int backRight) {
      
      enc1 = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
      enc2 = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
      enc3 = new Encoder(4, 5, false, Encoder.EncodingType.k4X);
      enc4 = new Encoder(6, 7, false, Encoder.EncodingType.k4X);

      count = enc1.get();
      


      FrontLeft = new VictorSPX(frontLeft);
     // FrontLeft.setSafetyEnabled(false);
     // RearLeft = new Victor(backLeft);
      FrontRight = new VictorSPX(frontRight);
     /// FrontRight.setSafetyEnabled(false);
     // RearRight = new Victor(backRight);
  
     //Left = new SpeedControllerGroup(FrontLeft);
     //Right = new SpeedControllerGroup(FrontRight);
  
      
     // m_drive = new DifferentialDrive(FrontLeft, FrontRight);
      //m_drive.setSafetyEnabled(false);
    }
  
    public static void drive(double speed, double turn){
      m_drive.arcadeDrive(speed, turn, false);

    }

    public static void runMotor(){
      FrontLeft.set(ControlMode.PercentOutput,0.5);
      FrontRight.set(ControlMode.PercentOutput,0.5);
      
     // FrontLeft.set(ControlMode.PercentOutput,1.0);
    }

    public static void stopMotor(){
      FrontLeft.set(ControlMode.PercentOutput,0);
      FrontRight.set(ControlMode.PercentOutput,0);
     // FrontLeft.set(ControlMode.PercentOutput,0);
        }
    
}
