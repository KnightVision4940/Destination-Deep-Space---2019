/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class TurnTable extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static TalonSRX TurnMotor= new TalonSRX(RobotMap.TurnTable);
  public static double TurnCoder = 0;
  public static double TurnRotate = 0;
  //D@nte Was Here

public void rotate(double speed){
  TurnMotor.set(ControlMode.PercentOutput, speed);
}
public int Encoder(){
return TurnMotor.getSelectedSensorPosition();
}



  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
