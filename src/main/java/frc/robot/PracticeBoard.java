/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Talon;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class PracticeBoard {
    static TalonSRX motor = new TalonSRX(0);
    public static void runMotor(){
        Xbox shackles = new Xbox(1);
        //motor.set(1);
        if(motor.getSelectedSensorPosition()/4069 <= -1){
            motor.set(ControlMode.PercentOutput,0);
        }else{
            motor.set(ControlMode.PercentOutput,1);
        }
        //System.out.println(shackles.getPOV(1));
       System.out.println(motor.getSelectedSensorPosition());
    }
    public static void stopMotor(){
        motor.set(ControlMode.PercentOutput,0);
      //  motor.set(0);
    }
}
