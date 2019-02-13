/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.XboxController; 


public class Drive extends Command {
  //public static XboxController Driver = new XboxController(1);

  public Drive() {
    requires(Robot.driveTrain);
    
    //requires(Robot.D_Control);
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
    Robot.driveTrain.drive(getTriggers(),Robot.m_oi.xBox.getRawAxis(1));
  }

  public static double getTriggers(){
    if(Robot.m_oi.xBox.getRawAxis(2) > Robot.m_oi.xBox.getRawAxis(3)){
      return Robot.m_oi.xBox.getRawAxis(2);
    } else {
      return -Robot.m_oi.xBox.getRawAxis(3);
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
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}