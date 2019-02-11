/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class Hatches extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static VictorSPX right;
  static VictorSPX left;

  public static void Hatch() {
      
  VictorSPX right = new VictorSPX(RobotMap.rightHatch);
  VictorSPX left = new VictorSPX(RobotMap.leftHatch);

   }
  public static void HatchesIn() {

      right.set(ControlMode.PercentOutput,0.5);
      left.set(ControlMode.PercentOutput,-0.5);

  }
 
  public static void HatchesOut() {

      right.set(ControlMode.PercentOutput,-0.5);
      left.set(ControlMode.PercentOutput,0.5);

}
  public static void HatchesStop() {

      right.set(ControlMode.PercentOutput,0);
      left.set(ControlMode.PercentOutput,0);

}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
