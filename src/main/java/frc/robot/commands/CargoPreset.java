/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.IntakeSystem;

public class CargoPreset extends Command {
  public static boolean inPosition[] = {false,false,false};
  public CargoPreset() {
  requires(Robot.arm);
  requires(Robot.intakeSystem);
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
    if(Robot.arm.endCountBase > 4){
      Robot.arm.moveShoulder(-0.5);
    }else if(Robot.arm.endCountBase < 4){
      Robot.arm.moveShoulder(0.5);
    }else{
      inPosition[0]= true;
    }
    if(Robot.arm.endCountElbow > 4){
      Robot.arm.moveElbow(-0.5);
    }else if(Robot.arm.endCountElbow < 4){
      Robot.arm.moveElbow(0.5);
    }else{
      inPosition[1]= true;
    }
    if(Robot.wrist.endCountWrist > 4){
      Robot.wrist.moveWrist(-0.5);
    }else if(Robot.wrist.endCountWrist < 4){
      Robot.wrist.moveWrist(0.5);
    }else{
      inPosition[2]= true;
    }
    if(inPosition[0] == true && inPosition[1] == true && inPosition[2] == true){
        shoot();
    }
    
  }

  void shoot(){
      setTimeout(0.6);
      IntakeSystem.Outtake(0.5);

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
