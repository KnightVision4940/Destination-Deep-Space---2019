/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import frc.robot.Robot;
import frc.robot.subsystems.PracticeMotor;
import frc.robot.subsystems.PracticeMotor;

/**
 * Add your docs here.
 */
public class RunMotor extends InstantCommand {
  // public static PracticeMotor Practice;
  /**
   * Add your docs here.
   */
  public RunMotor() {
    super("RunMotor");
    requires(Robot.Practice);
   //setTimeout(.9);
   // requires(Robot.Practice);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called once when the command executes
  @Override
  protected void initialize() {

    
  }
  protected void execute() {
    Robot.Practice.runMotor();
   // Practice.runMotor();
  }

  protected boolean isFinished() {
      return isTimedOut();
  }

  protected void end() {
   // Robot.claw.stop();
  }

  protected void interrupted() {
    end();
  }

}
