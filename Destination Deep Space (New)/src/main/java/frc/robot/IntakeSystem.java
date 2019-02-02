/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
/**
 * Add your docs here.
 */
public class IntakeSystem {

    static VictorSPX IntakeL;
    static VictorSPX IntakeR;
    static VictorSPX OuttakeL;
    static VictorSPX OuttakeR;

   public static void Intake() {

        IntakeL = new VictorSPX(RobotMap.leftRoller);
        IntakeL.set(ControlMode.PercentOutput,1);

        IntakeR = new VictorSPX(RobotMap.rightRoller);
        IntakeR.set(ControlMode.PercentOutput,1);

        }
    
    public static void Outtake() {

        OuttakeL = new VictorSPX(RobotMap.leftRoller);
        OuttakeL.set(ControlMode.PercentOutput,-1);

        OuttakeR = new VictorSPX(RobotMap.rightRoller);
        OuttakeR.set(ControlMode.PercentOutput,-1);

        }
    }
