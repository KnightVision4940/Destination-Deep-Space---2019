/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ManualArmControl extends Command {
  static double ArmSpeed = 0.5;
  public ManualArmControl() {
    requires(Robot.arm);
    requires(Robot.A_Control);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  //   if(Robot.arm.endCountBase >= 3){
  //     end();
  //   }else{
  //     Robot.arm.arm(ArmSpeed);
  //  }
  //  System.out.println(Robot.arm.endCountBase);
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.arm.arm(Robot.m_oi.getTriggersLogi());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
