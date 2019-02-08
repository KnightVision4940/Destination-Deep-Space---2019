/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


/*
 * Add your docs here.
 */
public class DriveTrain {

  //We are using TalonSRX
  static Talon FrontLeft;
  static TalonSRX FrontRight;
  static Talon BackLeft;
  static TalonSRX BackRight;

 

    //Our speed controllergroups for right and left 
   // public static SpeedControllerGroup Right;
    //public static SpeedControllerGroup Left;

    public static double count;
    public static Gyroscope g = new Gyroscope();
    public static int setpoint;
    public static int error;
    public static int p,i,d = 1;
    public static double integral;

    static DifferentialDrive m_drive; 
  //d@nte was here
    public DriveTrain(int frontLeft, int frontRight, int backLeft, int backRight) {
     
      
      FrontLeft = new Talon(frontLeft);
      BackLeft = new Talon(backLeft);
      FrontRight = new TalonSRX(frontRight);
      BackRight = new TalonSRX(backRight);
     // FrontLeft.setSelectedSensorPosition(0);
  
    SpeedControllerGroup Left = new SpeedControllerGroup(FrontLeft,BackLeft);
    SpeedControllerGroup Right = new SpeedControllerGroup(FrontRight, BackRight);
    
      
      m_drive = new DifferentialDrive(Left, Right);
      //m_drive.setSafetyEnabled(false);
    }
  
    public static void drive(double speed, double turn){
      m_drive.arcadeDrive(speed, turn, false);
    }

    //The drive we are going to use - needs testing
    public static void driveGyro(double speed, double turn){
      setpoint = (int)(turn * 180);
      error = setpoint - g.getAngle(); // What is Left = Target - Actual
      integral += error*0.02; //0.02 is the # of seconds for everytime this method is used
      double yeet = p*error + i*integral;
      m_drive.arcadeDrive(speed, yeet, false);
      //gab was here
    }

    public static void driveGyroWithReverseSteering(double speed, double turn){
      setpoint = (int)(turn * 180);
      error = setpoint - g.getAngle(); // What is Left = Target - Actual
      integral += error*0.02; //0.02 is the # of seconds for everytime this method is used
      double yeet = p*error + i*integral;
      if(speed >= 0){
        m_drive.arcadeDrive(speed, yeet, false);
      }else if(speed <= 0){
        m_drive.arcadeDrive(-speed, yeet, false);
      }else{
        m_drive.arcadeDrive(0, 0, false);
      }
      //gab was here
    }

    public static void SetPoint(double Xjoystick){
        setpoint = (int)(Xjoystick * 180);
    }


    //The rest is temporary
    public static void runMotor(){  
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

    
    
}
