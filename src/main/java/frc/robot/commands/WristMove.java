/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WristMove extends Command {
  public static double _Speed = -0.5;
  public WristMove() {
    requires(Robot.arm);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Robot.m_oi.getPOV() == 180 || Robot.m_oi.getPOV() == 135 || Robot.m_oi.getPOV() == 225){
    Robot.arm.moveWrist(_Speed);
    }else if(Robot.m_oi.getPOV() == 0 || Robot.m_oi.getPOV() == 45 || Robot.m_oi.getPOV() == 315){
      Robot.arm.moveWrist(-_Speed);
      }else{
      Robot.arm.moveWrist(0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.arm.moveWrist(0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}