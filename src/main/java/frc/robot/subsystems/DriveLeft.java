/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class DriveLeft extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static TalonSRX frontLeftMotor = new TalonSRX(RobotMap.frontLeft);
  static TalonSRX backLeftMotor = new TalonSRX(RobotMap.backLeft);


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static void drive(double speed) {
    frontLeftMotor.set(ControlMode.PercentOutput, speed);
    backLeftMotor.set(ControlMode.PercentOutput, speed);
  }
}
