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
/**
 * Add your docs here.
 */
public class Hatches extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static TalonSRX Hatch = new TalonSRX(RobotMap.hatch);
  
  public void init(){
   // Hatch.configSelectedFeedbackSensor(FeedbackDevice.PulseWidthEncodedPosition);
  // Hatch.configFactoryDefault();
  }
  public void HatchesRun(double speed) {

      Hatch.set(ControlMode.PercentOutput,speed);
     

  }
 
  public void HatchesStop() {

      Hatch.set(ControlMode.PercentOutput,0);
}
public int Encoder(){
  return Hatch.getSelectedSensorPosition();
  //return 1;
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
