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
public class IntakeSystem {

    public static Xbox xbox1 = new Xbox(3);
    public static Xbox xbox2 = new Xbox(1);
    static TalonSRX IntakeL;
    static TalonSRX IntakeR;
    static TalonSRX OuttakeL;
    static TalonSRX OuttakeR;

   public static void Intake() {

        IntakeL = new TalonSRX(RobotMap.leftRoller);
        IntakeL.set(ControlMode.PercentOutput,1);

        IntakeR = new TalonSRX(RobotMap.rightRoller);
        IntakeR.set(ControlMode.PercentOutput,1);

          IntakeL.set(ControlMode.PercentOutput,0);
          IntakeR.set(ControlMode.PercentOutput,0);
        }
    
    public static void Outtake() {

        OuttakeL = new TalonSRX(RobotMap.leftRoller);
        OuttakeL.set(ControlMode.PercentOutput,-1);

        OuttakeR = new TalonSRX(RobotMap.rightRoller);
        OuttakeR.set(ControlMode.PercentOutput,-1);

          OuttakeL.set(ControlMode.PercentOutput,0);
          OuttakeR.set(ControlMode.PercentOutput,0);
        }
    }
