/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import frc.robot.Gyroscope;
import frc.robot.Robot;
import frc.robot.CamServer;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Wrist;

public class UpdateDashboard extends Command {

  SendableChooser<Command> m_chooser = new SendableChooser<>();  public UpdateDashboard() {
    //requires(Robot.arm);
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
    // double time = 1;
    // int[] encoders = Robot.m_oi.getEncoders();
    // time = DriverStation.getInstance().getMatchTime();
    // SmartDashboard.putNumber("time left", time);

    // //Gyro
    // //sGyroscope g = new Gyroscope();
    // double gyro = Robot.m_oi.getGyro();
    // SmartDashboard.putNumber("gyro angle", gyro);
    // SmartDashboard.updateValues();
    // //Arm Angle = Baseangle
    
    // int Baseangle =  encoders[1];
    // SmartDashboard.putNumber("angle of Base", Baseangle);
    // SmartDashboard.updateValues();
    // //Arm Angle = ArmElbow
    //  int ArmElbow = encoders[2];
    // SmartDashboard.putNumber("angle of Elbow",ArmElbow); 
    // SmartDashboard.updateValues();
    // // Arm Angle = ArmWaist
    // int ArmWrist = encoders[3];
    // SmartDashboard.putNumber("angle of Wrist",ArmWrist);
    // SmartDashboard.updateValues();

    // // double turntable = Robot.table.Encoder();
    // // SmartDashboard.putNumber("angle of turntable",turntable);
    
    // //Robot Status 
  
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
