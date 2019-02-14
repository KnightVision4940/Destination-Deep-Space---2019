/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.commands.*;
/**
 * Add your docs here.
 */
public class Powertrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  /*
  private static TalonSRX FrLtMotor = new TalonSRX(RobotMap.frontLeft);
  private static TalonSRX RrLtMotor = new TalonSRX(RobotMap.backLeft);
  private static TalonSRX FrRtMotor = new TalonSRX(RobotMap.frontRight);
  private static TalonSRX RrRtMotor = new TalonSRX(RobotMap.backRight);
  */

  private static WPI_VictorSPX FrLtMotor = new WPI_VictorSPX(RobotMap.frontLeft);
  private static WPI_VictorSPX RrLtMotor = new WPI_VictorSPX(RobotMap.backLeft);
  private static WPI_VictorSPX FrRtMotor = new WPI_VictorSPX(RobotMap.frontRight);
  private static WPI_VictorSPX RrRtMotor = new WPI_VictorSPX(RobotMap.backRight);
  private static SpeedControllerGroup ltMotor = new SpeedControllerGroup(FrLtMotor,RrLtMotor);
  private static SpeedControllerGroup rtMotor = new SpeedControllerGroup(FrRtMotor, RrRtMotor);
  public static DifferentialDrive mDrive = new DifferentialDrive(ltMotor, rtMotor);
  public static void drive(double speedLeft, double speedRight){
    mDrive.tankDrive(speedLeft, speedRight);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveWithJoystick());
  }

  
}
