/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.RobotMap;
import frc.robot.subsystems.DriveTrain;
/**
 * Add your docs here.
 */
public class Climb extends Subsystem {

  //the speed of the motor need to be the exact smae
  //the direction of each motor should oppsite to each other *this is due to the ortaition of the motor*
  static TalonSRX climbMotor1 = new TalonSRX(RobotMap.climbmotor1);
  static TalonSRX climbMotor2 = new TalonSRX(RobotMap.climbmotor2);

    public static void climb(double speed){
      climbMotor1.set(ControlMode.PercentOutput, speed);
      climbMotor2.set(ControlMode.PercentOutput, -speed);
    }

    public static void climbStop(){
      climbMotor1.set(ControlMode.PercentOutput, 0);
      climbMotor2.set(ControlMode.PercentOutput, 0);
    }
    public static double encoder1(){
      return climbMotor1.getSelectedSensorVelocity();
    }
    public static double encoder2(){
      return climbMotor2.getSelectedSensorVelocity();

    }

    //this code is if we need to test each motor/speedcontroller indiviually 
    //they should usually run togethher at the smae speed 
    
    // public static void climbTest1(double speed){
    //   climbMotor1.set(speed);
    // }
    // public static void climbTest2(double speed){
    //   climbMotor2.set(-speed);
    // }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
