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
  public static double _Speed = -0.25;
  public static double encoder = 5000;
  public static double actualEncoder;
  public WristMove() {
   // requires(Robot.wrist);
   requires(Robot.wrist);
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
   actualEncoder = Robot.wrist.EncoderWrist();

    if(Robot.m_oi.getPOV() == -1){
      // if(actualEncoder >= (encoder)){
      //   Robot.wrist.moveWrist(0);
      // }else{
        Robot.wrist.moveWrist(0.07);
      //}
     
    }else{
      if(Robot.m_oi.getPOV() == 180 || Robot.m_oi.getPOV() == 135 || Robot.m_oi.getPOV() == 225){
        if(actualEncoder <= encoder){
          Robot.wrist.moveWrist(-0.30);
        }else{
          Robot.wrist.moveWrist(-0.15);
        }
       
       //Robot.arm.moveElbow(_Speed);
       // System.out.println("Wrist:" + Robot.wrist.EncoderWrist());
        }else if(Robot.m_oi.getPOV() == 0 || Robot.m_oi.getPOV() == 45 || Robot.m_oi.getPOV() == 315){
         Robot.wrist.moveWrist(0.30);
         // Robot.arm.moveElbow(-_Speed);
         // System.out.println("Wrist:" + Robot.wrist.EncoderWrist());
          }else{
            Robot.wrist.moveWrist(0);
  
        }
      //  Robot.wrist.EncoderWrist();
     }
    //System.out.println("Wrist:" + Robot.wrist.EncoderWrist());

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
    //System.out.println("Wrist:" + Robot.wrist.EncoderWrist());
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}