/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Robot;
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
      FrontLeft  = new WPI_VictorSPX(frontLeft);
      FrontLeft.setSafetyEnabled(false);
        FrontRight = new WPI_VictorSPX(frontRight);
      FrontRight.setSafetyEnabled(false);
        BackLeft = new WPI_VictorSPX(backLeft);
     BackLeft.setSafetyEnabled(false);
        BackRight = new WPI_VictorSPX(backRight);
      BackRight.setSafetyEnabled(false);
      SpeedControllerGroup Left = new SpeedControllerGroup(FrontLeft,BackLeft);
      SpeedControllerGroup Right = new SpeedControllerGroup(FrontRight, BackRight);
       
         
       m_drive = new DifferentialDrive(Left, Right);
      m_drive.setSafetyEnabled(false);
      m_drive.setExpiration(Robot.kDefaultPeriod);
    }

  
    public void drive(double speed, double turn){
     
     // m_drive.arcadeDrive(speed, turn, false);
     
     m_drive.arcadeDrive(speed, turn, true);
    }
    // public void driveGyro(double speed, double turn, double gyro){
    //   if(turn <= 0.1 && turn >= -0.1 && gyro < 0.5 && gyro > -0.5){
    //     m_drive.arcadeDrive(speed, -(gyro) * 0.25, false);
    //   }else{
    //     m_drive.arcadeDrive(speed, turn,false);
    //   }
    // }


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
    //   //gab was heres
    // }

    //Drivetrain created by team 2609. Hope this works
    //https://github.com/frc2609/FIRSTPRESEASON2017/blob/master/src/org/usfirst/frc/team2609/robot/Robot.java

    public void CustomDrivetrain(double speed, double turn){
      double deadZone = 0.15;
      double X = speed;
          double Y = turn;
          if ((Math.abs(-speed)<deadZone) && (Math.abs(-turn)<deadZone)){
            X = 0;
            Y = 0;
          }
          /*if (Math.abs(-driveStick.getRawAxis(1))<deadZone){
            Y = 0;
          }*/
          double leftOutput;
          double rightOutput;
          if (Y > 0) {
              if (X > 0.0) {
                  leftOutput = Math.pow(Y, 1) - Math.pow(X, 1);
                  rightOutput = Math.max(Math.pow(Y, 1), Math.pow(X, 1));
              } else {
                  leftOutput = Math.max(Math.pow(Y, 1), -(Math.pow(X, 1)));
                  rightOutput = Math.pow(Y, 1) + (Math.pow(X, 1));
              }
          } else{
              if (X > 0.0) {
                  leftOutput = -Math.max(-(Math.pow(Y, 1)), Math.pow(X, 1));
                  rightOutput = (Math.pow(Y, 1)) + Math.pow(X, 1);
              } else {
                //this is also vvv imborktant
                  leftOutput = (Math.pow(Y, 1)) - (Math.pow(X, 1));
                  rightOutput = -Math.max(-(Math.pow(Y, 1)), -(Math.pow(X, 1)));
              }
                
  
          }
            
  //        
         FrontLeft.set(ControlMode.PercentOutput,leftOutput);
         BackLeft.set(ControlMode.PercentOutput,leftOutput);

         FrontRight.set(ControlMode.PercentOutput,rightOutput);
         BackRight.set(ControlMode.PercentOutput,rightOutput);

    }


    public static void forward(double speed){
        m_drive.arcadeDrive(speed, 0);
    }

    public static void SetPoint(double Xjoystick){
        setpoint = (int)(Xjoystick * 180);
    }
  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new Drive());
    //Uncomment the next line to test out this drive.
   // setDefaultCommand(new Drive());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
