/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Gyroscope;
import frc.robot.Robot;

public class UpdateDashboard extends Command {
  public UpdateDashboard() {
    requires(Robot.arm);
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
    double time = 1;
    time = DriverStation.getInstance().getMatchTime();
    SmartDashboard.putNumber("time left", time);

    //Gyro
    Gyroscope g = new Gyroscope();
    int gyro = g.getAngle();
    SmartDashboard.putNumber("gyro angle", gyro);

    //Arm Angle = Baseangle
    
    double Baseangle =  a.endCountBase;
    SmartDashboard.putNumber("angle of Base", Baseangle);
    
    //Arm Angle = ArmElbow
     double ArmElbow = a.endCountElbow;
    SmartDashboard.putNumber("angle of Elbow",ArmElbow); 

    // Arm Angle = ArmWaist
    double ArmWaist = a.endCountWrist;
    SmartDashboard.putNumber("angle of Waist",ArmWaist);
    
    //Robot Status  
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
