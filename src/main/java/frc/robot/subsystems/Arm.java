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
  public static TalonSRX armBase = new TalonSRX(RobotMap.armBase);
  public static TalonSRX armElbow = new TalonSRX(RobotMap.armElbow);
  public static TalonSRX armWrist = new TalonSRX(RobotMap.armWrist);

  public static double endCountBase = 0;
  public static double endCountElbow = 0;
  public static double endCountWrist = 0;

public static void init(){
    armBase.setSelectedSensorPosition(0);
    armElbow.setSelectedSensorPosition(0);
    armWrist.setSelectedSensorPosition(0);
}

  public static void stopMotor() {
      armBase.set(ControlMode.PercentOutput,0);
      armElbow.set(ControlMode.PercentOutput,0);
  }


    //D@nte was here


public static void arm(double speed) {
  
     armBase.set(ControlMode.PercentOutput,speed);
     endCountBase = -(armBase.getSelectedSensorPosition(0) /4069);
     

    armElbow.set(ControlMode.PercentOutput,speed);
    endCountElbow = -(armElbow.getSelectedSensorPosition(0) /4069);
      
  }
  public static void moveShoulder(double speed){
    armBase.set(ControlMode.PercentOutput,speed);
    endCountBase = -(armBase.getSelectedSensorPosition(0) /4069);
  }
  public static void moveElbow(double speed){
    armElbow.set(ControlMode.PercentOutput,speed);
    endCountBase = -(armBase.getSelectedSensorPosition(0) /4069);
  }
  public static void moveWrist(double speed){
    armWrist.set(ControlMode.PercentOutput,speed);
    endCountBase = -(armBase.getSelectedSensorPosition(0) /4069);
  }
  


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
