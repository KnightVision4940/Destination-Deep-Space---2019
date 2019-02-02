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

    static TalonSRX armBase;
    static TalonSRX armElbow;

public static void armUp() {

    IntakeL = new TalonSRX(RobotMap.armBase);
        IntakeL.set(ControlMode.PercentOutput,0.5);

        IntakeR = new TalonSRX(RobotMap.rightRoller);
        IntakeR.set(ControlMode.PercentOutput,1);

}

public static void armDown() {

}

}
