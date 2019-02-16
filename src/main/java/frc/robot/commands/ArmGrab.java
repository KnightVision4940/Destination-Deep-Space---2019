/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Arm;

public class ArmGrab extends Command {
  int i1 = 0;
  int i2 = 0;
  boolean run = false;
  public ArmGrab() {
    requires(Robot.arm);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    i1 = 0;
    i2 = 0;
    run = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
 
    if(i1 >= 250){
      Arm.armBase.set(ControlMode.PercentOutput, 0);
    }
    else{
      Arm.moveShoulder(0.5);
    }
    if(i2 >= 100){
      Arm.armElbow.set(ControlMode.PercentOutput, 0);
      }
      else{
      Arm.moveElbow(0.5);        
      }
      if(i2>= 100 && i1 >= 250){
      run = true;
  }
  i1++;
 i2++;
 System.out.println("i1:"+i1);
 System.out.println("i2:"+i2);
}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return run;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Arm.armBase.set(ControlMode.PercentOutput, 0);
    Arm.armElbow.set(ControlMode.PercentOutput, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}

