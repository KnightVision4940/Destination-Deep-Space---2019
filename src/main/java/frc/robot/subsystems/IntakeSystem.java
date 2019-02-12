/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
/**
 * Add your docs here.
 */
public class IntakeSystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  static TalonSRX Left = new TalonSRX(RobotMap.leftRoller);  
  static VictorSPX Right  = new VictorSPX(RobotMap.rightRoller);


 public static void Intake(Double speed) {

      
      Left.set(ControlMode.PercentOutput,speed);
      Right.set(ControlMode.PercentOutput,speed);


      }
  
  public static void Outtake(Double speed) {

      Left.set(ControlMode.PercentOutput,speed);
      Right.set(ControlMode.PercentOutput,speed);

      }
  public static void stop(){
        Left.set(ControlMode.PercentOutput,0);
        Right.set(ControlMode.PercentOutput,0);
    
      }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
