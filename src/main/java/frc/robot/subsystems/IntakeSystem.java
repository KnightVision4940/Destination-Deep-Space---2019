/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class IntakeSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static VictorSPX Left = new VictorSPX(RobotMap.leftRoller);  
  static VictorSPX Right  = new VictorSPX(RobotMap.rightRoller);

 public void Intake(Double L,Double R) {
      Left.set(ControlMode.PercentOutput,L);
      Right.set(ControlMode.PercentOutput,R);
      }
      // public void Intake(Double L,Double R) {
      //   Left.set(ControlMode.PercentOutput,-speed);
      //   Right.set(ControlMode.PercentOutput,speed);
      //   }
      public void Outtake(Double speed) {
        Left.set(ControlMode.PercentOutput,speed);
        Right.set(ControlMode.PercentOutput,-speed);
        }
  
  public void stop(){
        Left.set(ControlMode.PercentOutput,0);
        Right.set(ControlMode.PercentOutput,0);
      }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
