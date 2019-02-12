/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class DriveLEft extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static TalonSRX frontLeftMotor = new TalonSRX(RobotMap.frontleft);
  static TalonSRX backLeftMotor = new TalonSRX(RobotMap.backLeftMotor);


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static void run(Double speed) {
    frontLeftMotor.set(ControlMode.PercentOutput, speed);
    backLeftMotor.set(ControlMode.PercentOutput, -speed);
  }
}
