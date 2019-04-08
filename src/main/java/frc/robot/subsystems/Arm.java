/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
//import frc.robot.Xbox;
/**
 * Add your docs here.
 */
public class Arm extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  //public static TalonSRX armBase = new TalonSRX(RobotMap.armBase);
  static TalonSRX armElbow = new TalonSRX(RobotMap.armElbow);
 

  static double endCountBase = 0;
  static double endCountElbow = 0;

  public void stopMotor() {
     // armBase.set(ControlMode.PercentOutput,0);
      armElbow.set(ControlMode.PercentOutput,0);
  }


    //D@nte was here
  public void moveShoulder(double speed){
    // armBase.set(ControlMode.PercentOutput,speed);
    // endCountBase = -(armBase.getSelectedSensorPosition(0) /4069);
  }
  public void moveElbow(double speed){
    if(speed > 0){
      armElbow.set(ControlMode.PercentOutput,speed);
    }else{
      armElbow.set(ControlMode.PercentOutput,speed*0.25);
    }
  //  endCountBase = -(armBase.getSelectedSensorPosition(0) /4069);
  }
  
  public int EncoderShoulder(){
  // return armBase.getSelectedSensorPosition();
  return 0;
  }
  public int EncoderElbow(){
    //return 4;
     return armElbow.getSelectedSensorPosition();
   }


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
