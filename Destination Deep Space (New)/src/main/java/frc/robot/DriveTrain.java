/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/*
 * Add your docs here.
 */
public class DriveTrain {

  //We are using TalonSRX
  static TalonSRX FrontLeft;
  static TalonSRX FrontRight;

  static ADXRS450_Gyro gyro;

    //Our speed controllergroups for right and left 
    SpeedControllerGroup Right;
    SpeedControllerGroup Left;

    public static double count;
  
    static DifferentialDrive m_drive; 
  //d@nte was here
    public DriveTrain(int frontLeft, int frontRight, int backLeft, int backRight) {

      

      
      FrontLeft = new TalonSRX(frontLeft);
      FrontLeft.setSelectedSensorPosition(0);
  
     //Left = new SpeedControllerGroup(FrontLeft);
     //Right = new SpeedControllerGroup(FrontRight);
  
      
     // m_drive = new DifferentialDrive(FrontLeft, FrontRight);
      //m_drive.setSafetyEnabled(false);
    }
  
    // public static void drive(double speed, double turn){
    //   m_drive.arcadeDrive(speed, turn, false);

    // }
    
    public static void runMotor(){
      
      //  System.out.println(gyro.getAngle());
      // FrontLeft.set(ControlMode.PercentOutput,1);
       count = -(FrontLeft.getSelectedSensorPosition(0) /4069);
       //System.out.println(count);
      //  if(Math.round(count) % 0.5 == 0){

      //  }
      //System.out.println(FrontLeft.getSelectedSensorVelocity(0));
      
     //FrontRight.set(ControlMode.PercentOutput,0.5);
      
     // FrontLeft.set(ControlMode.PercentOutput,1.0);
    }
      
    public static void stopMotor(){
      FrontLeft.set(ControlMode.PercentOutput,0);
        }

    // public static void reset(){
    //   gyro.reset();
    // }
    // public static void calibrategyro(){
    //   gyro.calibrate();
    // }
    
}
