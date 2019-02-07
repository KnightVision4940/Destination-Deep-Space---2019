/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;;


/**
 * Add your docs here.
 */
public class TurnTable {
    //turn is out motor and function
    public static TalonSRX TurnMotor= new TalonSRX(0);
    public static double TurnCoder = 0;
    public static double TurnRotate = 0;
    

public static void Turn(double speed){
    
    TurnMotor.set(ControlMode.PercentOutput, speed);
    TurnCoder = -(TurnMotor.getSelectedSensorPosition());
    TurnRotate = (TurnCoder/4069);
    if(TurnRotate == 1 && speed == 0.5){
        TurnMotor.set(ControlMode.PercentOutput, 0);
    }else if(TurnRotate == -1 && speed == -0.5){
        TurnMotor.set(ControlMode.PercentOutput, 0);
    }

}

}
