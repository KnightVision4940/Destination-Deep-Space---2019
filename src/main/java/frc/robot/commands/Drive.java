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


public class Drive extends Command {
 // public static XboxController Driver = new XboxController(1);
static double var1;
static double var2;

  public Drive() {
    requires(Robot.driveTrain);
    //requires(Robot.gyro);
    //requires(Robot.D_Control);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.driveTrain.driveInit();
  // Robot.gyro.gyroInit();
  // Robot.gyro.calibrategyro();
  //Robot.gyro.reset();
    //Robot.driveTrain.drive(Robot.m_oi.xBox.getY(),Robot.m_oi.xBox.getX());
   // System.out.println(Robot.m_oi.xBox.getThrottle());
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   
  
 //  System.out.println("Turn:" + Robot.m_oi.getX());
  // System.out.println("Triggers" + Robot.m_oi.getTriggers()*0.7);
  // System.out.println("Gyro" + Robot.gyro.getAngle());
  Robot.driveTrain.drive(-Robot.getTriggers()*0.9,Robot.getX()*0.8);
  //var1 = -Robot.getTriggers();
  //var2 = Robot.getX();
  //SmartDashboard.putNumber("Trigger:", var1);
  //SmartDashboard.putNumber("Turn:", var2);
 // SmartDashboard.putNumber(key, value)
  //Robot.driveTrain.CustomDrivetrain(Robot.getTriggers()*0.9,Robot.getX()*0.8);
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