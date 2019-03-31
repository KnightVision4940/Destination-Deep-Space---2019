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
  // int sh_e_back = 4152;
  // int sh_e_front = 4400;
  // int sh_e_front2 = 4750;
  int e_e_up;
  int e_e_down;
  public ManualArmControl() {
    requires(Robot.arm);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    e_e_down = Robot.arm.EncoderElbow();
    e_e_up = e_e_down + 2000;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  // OldMode();
   NormalMode(Robot.m_oi.getYLogiR(),Robot.arm.EncoderElbow());

   }
   void NormalMode(double joystickR, int encoder){
     
    //if statement to keep arm up
    if(joystickR >= -0.15 && joystickR <= 0.15){
      Robot.arm.moveElbow(0.08);
    }else{
      Robot.arm.moveElbow(joystickR*-0.42);
    }

    //Puts encoder on SmartDashboard
    
   }

   void IfDoesntWorkNormalMode(){
     
    if(Robot.m_oi.getYLogiR() >= -0.15 && Robot.m_oi.getYLogiR() <= 0.15){
      Robot.arm.moveElbow(0.08);
    }else{
      Robot.arm.moveElbow(Robot.m_oi.getYLogiR()*-0.42);
    }
   // Robot.arm.moveShoulder(-Robot.m_oi.getYLogiL()*-0.42);
    System.out.println("Elbow:" + Robot.arm.EncoderElbow());
    //System.out.println("Shoulder:" + Robot.arm.EncoderShoulder());
   }

   void OldMode(){
     
    //the if statment means if your at this position & the robot is moving away from position than move at -47% speed 
  //   if(Robot.arm.EncoderElbow() <= 8500){
  //     sh_e_front = sh_e_front2;
  //   }else {
  //     sh_e_front = 4400;
  //   }

  //   if(Robot.arm.EncoderElbow() <= e_e_up && Robot.m_oi.getYLogiL() < 0.1 && Robot.m_oi.getYLogiL() > -0.1 && (Robot.m_oi.getYLogiR() > 0.1 || Robot.m_oi.getYLogiR() < -0.1)){
  //     Robot.arm.moveShoulder(-0.35);
  //   }else if(Robot.arm.EncoderShoulder() <= sh_e_back && Robot.m_oi.getYLogiL() > 0){
  //     Robot.arm.moveShoulder(0);
  //  }else if (Robot.arm.EncoderShoulder() >= sh_e_front && Robot.m_oi.getYLogiL() < 0){
  //     Robot.arm.moveShoulder(0);
  //   }else{
  //     Robot.arm.moveShoulder(-Robot.m_oi.getYLogiL()*-0.42);
  //   }
  
  //   System.out.println("Shoulder:" + Robot.arm.EncoderShoulder());
    
  
      // if(){
      //   
      // }
    

  //   if(Robot.arm.EncoderElbow() <= e_e_up && Robot.m_oi.getYLogiR() < 0){
  //     Robot.arm.moveElbow(0.12);
  //  }else if (Robot.arm.EncoderElbow() >= e_e_down && Robot.m_oi.getYLogiR() > 0){
  //   Robot.arm.moveElbow(0);
  // }else{
    if(Robot.m_oi.getYLogiR() >= -0.15 && Robot.m_oi.getYLogiR() <= 0.15 && Robot.arm.EncoderElbow() >= e_e_up){
      Robot.arm.moveElbow(0.12);
    }else{
      Robot.arm.moveElbow(Robot.m_oi.getYLogiR()*-0.42);
   // }
  }
  //Robot.m_oi.addArm(Robot.arm.EncoderElbow(),1);
  System.out.println("Elbow:" + Robot.arm.EncoderElbow());
  System.out.println("TRY THIS" + Robot.m_oi.getYLogiR());
   }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns trues
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
