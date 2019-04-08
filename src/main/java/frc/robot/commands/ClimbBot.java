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

public class ClimbBot extends Command {
  double ClimbSpeed;
  double ClimbSpeed2;
  double encoder1;
  double encoder2;
  boolean start = true;
  public ClimbBot(double speed) {
    requires(Robot.Climb);
    ClimbSpeed = speed;
    ClimbSpeed2 = -speed;
    encoder1 = Robot.Climb.encoder1();
    encoder2 = Robot.Climb.encoder2();


    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if(encoder1 !=0 && encoder2 == 0){
      Robot.Climb.climbStop();
    }else if(encoder1 ==0 && encoder2 != 0){
      Robot.Climb.climbStop();
    }else {
      Robot.Climb.climb(-ClimbSpeed);
     // start = false;
    }
    encoder1 = Robot.Climb.encoder1();
    encoder2 = Robot.Climb.encoder2();
    SmartDashboard.putNumber("Climb A:", encoder1);
    SmartDashboard.putNumber("Climb B:", encoder2);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.Climb.climbStop();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
