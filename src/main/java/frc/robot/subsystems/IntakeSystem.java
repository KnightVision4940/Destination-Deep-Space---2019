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
public class IntakeSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static VictorSPX IntakeL;
  static VictorSPX IntakeR;
  static VictorSPX OuttakeL;
  static VictorSPX OuttakeR;

 public static void Intake(Double speed) {

      IntakeL = new VictorSPX(RobotMap.leftRoller);
      IntakeL.set(ControlMode.PercentOutput,speed);

      IntakeR = new VictorSPX(RobotMap.rightRoller);
      IntakeR.set(ControlMode.PercentOutput,speed);

      }
  
  public static void Outtake(Double speed) {

      OuttakeL = new VictorSPX(RobotMap.leftRoller);
      OuttakeL.set(ControlMode.PercentOutput,speed);

      OuttakeR = new VictorSPX(RobotMap.rightRoller);
      OuttakeR.set(ControlMode.PercentOutput,speed);

      }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
