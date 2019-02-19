/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
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

  public static void HatchesIn(double speed) {

      Hatch.set(ControlMode.PercentOutput,speed);

  }
 
  public static void HatchesOut(double speed) {

      Hatch.set(ControlMode.PercentOutput,speed);

}
  public static void HatchesStop() {

      Hatch.set(ControlMode.PercentOutput,0);
}
public static int Encoder(){
  return Hatch.getSelectedSensorPosition();
  //return 1;
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
