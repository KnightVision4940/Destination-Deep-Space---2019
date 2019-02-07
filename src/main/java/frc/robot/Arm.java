/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;


/**
 * Add your docs here.
 */
public class Arm {

    public static TalonSRX armBase = new TalonSRX(RobotMap.armBase);
    public static TalonSRX armElbow = new TalonSRX(RobotMap.armElbow);
      
    public static double endCountBase = 0;
    public static double endCountElbow = 0;
  public static void init(){
      armBase.setSelectedSensorPosition(0);
      armElbow.setSelectedSensorPosition(0);
  }

    public static void stopMotor() {
        armBase.set(ControlMode.PercentOutput,0);
        armElbow.set(ControlMode.PercentOutput,0);
    }

    public static void grabMode(){



    }

  public static void placeMode(){

      

  }
