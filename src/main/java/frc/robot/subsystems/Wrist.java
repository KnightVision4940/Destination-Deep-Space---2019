/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Wrist extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static TalonSRX armWrist = new TalonSRX(RobotMap.armWrist);
  static int encoderSaved1;
//  public static double endCountWrist = 0;

  public void moveWrist(double speed){
    armWrist.set(ControlMode.PercentOutput,speed);
    //endCountWrist = -(armWrist.getSelectedSensorPosition(0) /4069);
  }

public int EncoderWrist(){
  return armWrist.getSelectedSensorPosition();
}

public void StoreEncoders(int grabBalls){
  encoderSaved1 = grabBalls;
}
public int getEncoderSaved(){
  return encoderSaved1;
}
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
