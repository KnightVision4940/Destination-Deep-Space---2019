/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class HatchesDrop extends Command {
  static double HSpeed = -0.25;
  static int i = 0;
  static boolean run = false;
  public HatchesDrop() {
    requires(Robot.H);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    i= 0;
    run =false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //if(-(Robot.H.Encoder()) > 4069){
    // if(i > 100){
    //   run  =true;
    //  // i = 0;
    // }else{
      Robot.H.HatchesIn(-0.3);
      // i++;
  //   }
  //   System.out.println(i);
   }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return run;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.H.HatchesStop();
   i = 0;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //Robot.H.HatchesStop();
      end();
  }
}
