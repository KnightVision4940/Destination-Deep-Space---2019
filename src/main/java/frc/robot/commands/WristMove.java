/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

public class WristMove extends Command {
  public static double _Speed = -0.25;
  public static int downLimit;
  public static int startLimit;
  public static int actualEncoder;
  public static int dpad;

  public WristMove() {
    requires(Robot.wrist);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if(Robot.ran = false){
    startLimit = Robot.wrist.EncoderWrist();
    downLimit = startLimit + 2000;
    Robot.wrist.StoreEncoders(downLimit);
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    actualEncoder = Robot.wrist.EncoderWrist();
    dpad = Robot.m_oi.getPOV();

    //Not Touched
    if (dpad == -1) {
      Robot.wrist.moveWrist(0.07);

    //Touching Down 
    } else if (dpad == 180 || dpad == 135 || dpad == 225) {
      Robot.wrist.moveWrist(-0.15);

    //Touching Up
    } else if ((dpad == 0 || dpad == 45 || dpad == 315)) {
      Robot.wrist.moveWrist(0.30);
    }
    SmartDashboard.putNumber("Wrist:", actualEncoder);
  }
  

  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.wrist.moveWrist(0);
    // System.out.println("Wrist:" + Robot.wrist.EncoderWrist());
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}