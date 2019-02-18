/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.commands.Drive;
import frc.robot.RobotMap;;
/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  
       
       
     
  static WPI_VictorSPX FrontLeft;
  static WPI_VictorSPX FrontRight;
  static WPI_VictorSPX BackLeft;
  static WPI_VictorSPX BackRight;

 

    //Our speed controllergroups for right and left 
   // public static SpeedControllerGroup Right;
    //public static SpeedControllerGroup Left;

    public static double count;
    // public static Gyroscope g = new Gyroscope();
    public static int setpoint;
    public static int error;
    public static int p,i,d = 1;
    public static double integral;

    static DifferentialDrive m_drive; 
  //d@nte was here
    public DriveTrain(int frontLeft, int frontRight, int backLeft, int backRight) {
     
      
      // FrontLeft = new WPI_VictorSPX(frontLeft);
      // BackLeft = new WPI_VictorSPX(backLeft);
      // FrontRight = new WPI_VictorSPX(frontRight);
      // BackRight = new WPI_VictorSPX(backRight);
      //FrontLeft = new WPI_TalonSRX(frontLeft);
      //BackLeft = new WPI_TalonSRX(backLeft);
    //  FrontRight = new WPI_TalonSRX(frontRight);
      //BackRight = new WPI_TalonSRX(backRight);
     // FrontLeft.setSelectedSensorPosition(0);
  
     
   
    }
    public static void driveInit(){
      FrontLeft  = new WPI_VictorSPX(RobotMap.frontLeft);
      FrontRight = new WPI_VictorSPX(RobotMap.backLeft);
      BackLeft = new WPI_VictorSPX(RobotMap.frontRight);
      BackRight = new WPI_VictorSPX(RobotMap.backRight);
      SpeedControllerGroup Left = new SpeedControllerGroup(FrontLeft,BackLeft);
      SpeedControllerGroup Right = new SpeedControllerGroup(FrontRight, BackRight);
      
        
      m_drive = new DifferentialDrive(Left, Right);
        m_drive.setSafetyEnabled(false);
    }
  
    public static void drive(double speed, double turn){
      m_drive.arcadeDrive(speed, turn, false);
    }
    public static void driveGyro(double speed, double turn, double gyro){
      if(turn != 0 || gyro < 0.5 || gyro > -0.5){
        m_drive.arcadeDrive(speed, turn, false);
      }else{
        m_drive.arcadeDrive(speed, -(gyro),false);
      }
    }

    //The drive we are going to use - needs testing
    // public static void driveGyro(double speed, double turn){
    //   setpoint = (int)(turn * 180);
    //   error = setpoint - g.getAngle(); // What is Left = Target - Actual
    //   integral += error*0.02; //0.02 is the # of seconds for everytime this method is used
    //   double yeet = p*error + i*integral;
    //   m_drive.arcadeDrive(speed, yeet, false);
    //   //gab was here
    // }

    // public static void driveGyroWithReverseSteering(double speed, double turn){
    //   setpoint = (int)(turn * 180);
    //   error = setpoint - g.getAngle(); // What is Left = Target - Actual
    //   integral += error*0.02; //0.02 is the # of seconds for everytime this method is used
    //   double yeet = p*error + i*integral;
    //   if(speed >= 0){
    //     m_drive.arcadeDrive(speed, yeet, false);
    //   }else if(speed <= 0){
    //     m_drive.arcadeDrive(-speed, yeet, false);
    //   }else{
    //     m_drive.arcadeDrive(0, 0, false);
    //   }
    //   //gab was here
    // }

    public static void forward(double speed){
        m_drive.arcadeDrive(speed, 0);
    }

    public static void SetPoint(double Xjoystick){
        setpoint = (int)(Xjoystick * 180);
    }
  @Override
  public void initDefaultCommand() {
    //Uncomment the next line to test out this drive.
   // setDefaultCommand(new Drive());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
