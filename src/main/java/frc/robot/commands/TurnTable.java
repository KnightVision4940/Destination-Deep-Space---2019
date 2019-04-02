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

public class TurnTable extends Command {
  int encoder;
  double triggerValue;
  public static int i = 0;
  int e_mid = 0;
  int e_left = -3490;
  int e_right = 1011;

  public TurnTable() {
    requires(Robot.table);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    e_mid = Robot.table.Encoder();
    e_left = e_mid - 2000;
    e_right = e_mid + 2000;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    encoder = Robot.table.Encoder();
    triggerValue = Robot.m_oi.getTriggersLogi();

    // + Trigger Value means left trigger
    // - Trigger Value means right trigger
    if (encoder <= e_left && triggerValue > 0) {
      Robot.table.rotate(0);
    } else if (encoder >= e_right && triggerValue < 0) {
      Robot.table.rotate(0);
    } else {
      Robot.table.rotate(triggerValue * 0.25);

    }
    SmartDashboard.putNumber("Turn Table:", encoder);

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
  }
}
