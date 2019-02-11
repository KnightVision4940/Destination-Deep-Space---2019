/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrain;
/**
 * Add your docs here.
 */
public class Climb extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  static TalonSRX climbMotor = new TalonSRX(RobotMap.climbmotor);

    public static void climb(int stage){
        switch(stage){
        case 1: 
            climbMotor.set(ControlMode.PercentOutput,1); 
        break;
        case 2:
            climbMotor.set(ControlMode.PercentOutput,1); 
            DriveTrain.forward(1);
        break;
        case 3:
            climbMotor.set(ControlMode.PercentOutput,-1); 
            DriveTrain.forward(1);
        break;
        case 4:
            climbMotor.set(ControlMode.PercentOutput,0); 
            DriveTrain.forward(0);  
        break;
        }
    }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}