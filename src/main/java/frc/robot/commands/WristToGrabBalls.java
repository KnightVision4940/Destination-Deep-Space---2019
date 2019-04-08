/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class WristToGrabBalls extends Command {
    static int e_grab;
    static int e_current;
    static boolean up;
    static boolean stopRunning = false;
  public WristToGrabBalls() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.wrist);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
     e_grab = 3857;
      e_current = Robot.wrist.EncoderWrist();
      if(e_current < e_grab){
        goDown();
      }else if (e_current > e_grab){
          goUp();
      }else{
        stopRunning = true;
      }
      stopRunning = true;
  }

  void goDown(){
   // System.out.println("This is being called" + e_grab);
    while(e_current < (e_grab-150)){
        Robot.wrist.moveWrist(-0.15);
        //Robot.wrist.moveWrist(-0.10*((e_current - e_grab)/1000));
        // if(e_grab - e_current < 1000){
        //   Robot.wrist.moveWrist(-0.10);
        // }else{
        //   Robot.wrist.moveWrist(-0.10*((e_current - e_grab)/1000));
        // }
        e_current = Robot.wrist.EncoderWrist();
    }
  }

  void goUp(){
    while(e_current > e_grab){
        Robot.wrist.moveWrist(0.25);
        e_current = Robot.wrist.EncoderWrist();
    }
  }
  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {

     
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return stopRunning;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
      Robot.wrist.moveWrist(0);
      Robot.startCommand();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
      end();
  }
}
