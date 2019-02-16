/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveWithJoystick extends Command {
  public DriveWithJoystick() {
    requires(Robot.powertrain);
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
   //Robot.powertrain.drive(Robot.m_oi.logicTech.getY(Hand.kLeft),Robot.m_oi.logicTech.getY(Hand.kRight));
   Robot.powertrain.drive(Robot.m_oi.getYLogiL(),Robot.m_oi.getYLogiR());
    /*
   if (Robot.m_oi.logicTech.getRawButton(RobotMap.LogicFullSpeed)) {
    Robot.powertrain.driveF(Robot.m_oi.logicTech.getY(Hand.kLeft),Robot.m_oi.logicTech.getY(Hand.kRight));
   }else{
    Robot.powertrain.drive(Robot.m_oi.logicTech.getY(Hand.kLeft),Robot.m_oi.logicTech.getY(Hand.kRight));
   }
   */
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.powertrain.drive(0,0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
