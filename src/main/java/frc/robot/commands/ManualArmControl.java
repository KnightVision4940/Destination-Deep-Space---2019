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
  int sh_e_back = 1516;
  int sh_e_front = 1889;
  int e_e_up = -3000;
  public ManualArmControl() {
    requires(Robot.arm);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    
  //   if(Robot.arm.endCountBase >= 3){
  //     end();
  //   }else{
  //     Robot.arm.arm(ArmSpeed);
  //  }
  //  System.out.println(Robot.arm.endCountBase);
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
   

    //the if statment means if your at this position & the robot is moving away from position than move at -47% speed 
     if(Robot.arm.EncoderShoulder() <= sh_e_back && Robot.m_oi.getYLogiL() > 0){
        Robot.arm.moveShoulder(0);
     }else if (Robot.arm.EncoderShoulder() >= sh_e_front && Robot.m_oi.getYLogiL() < 0){
        Robot.arm.moveShoulder(0);
      }else{
        Robot.arm.moveShoulder(-Robot.m_oi.getYLogiL()*-0.42);
      }

      if(Robot.arm.EncoderElbow() <= e_e_up && Robot.m_oi.getYLogiR() < 0){
        Robot.arm.moveElbow(0);
     }else{
        Robot.arm.moveElbow(-Robot.m_oi.getYLogiL()*-0.42);
      }



    //the if statment means if your not giving eoungh power trok to the eblow then move up at 10% speed 
      if(Robot.m_oi.getYLogiR() >= -0.02 && Robot.m_oi.getYLogiR() <= 0.15){
        Robot.arm.moveElbow(0.10);
      }else{
        Robot.arm.moveElbow(Robot.m_oi.getYLogiR()*-0.42);
      }

  //  System.out.println("Trigger Value:" + Robot.m_oi.getTriggersLogi());
  //  // Robot.arm.arm(Robot.m_oi.getTriggersLogi()*0.50);
    
    System.out.println("Encoder Arm Shosulder: "+ Robot.arm.EncoderShoulder());
     System.out.println("Encoder Arm Elbow: "+ Robot.arm.EncoderElbow());
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
