/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

// package frc.robot;
// import com.ctre.phoenix.motorcontrol.can.TalonSRX;
// import com.ctre.phoenix.motorcontrol.ControlMode;


// /**
//  * Add your docs here.
//  */
// public class Arm {

//     public static TalonSRX armBase = new TalonSRX(RobotMap.armBase);
//     public static TalonSRX armElbow = new TalonSRX(RobotMap.armElbow);
//     // armBase.setSelectedSensorPosition(0);
//     // armElbow.setSelectedSensorPosition(0);
//     public static double endCountBase = 0;
//     public static double endCountElbow = 0;


//     public static void stopMotor() {
//         armBase.set(ControlMode.PercentOutput,0);
//         armElbow.set(ControlMode.PercentOutput,0);
//     }


// public static void armUp() {
    
//     if(endCountBase == 10 && endCountElbow == 10) {

//         stopMotor();

//     }else{

//        armBase.set(ControlMode.PercentOutput,0.5);
//        endCountBase = -(armBase.getSelectedSensorPosition(0) /4069);

//         armElbow.set(ControlMode.PercentOutput,0.5);
//         endCountElbow = -(armElbow.getSelectedSensorPosition(0) /4069);
//     }
    

//     // IntakeL = new TalonSRX(RobotMap.armBase);
//     //     IntakeL.set(ControlMode.PercentOutput,0.5);

//     //     IntakeR = new TalonSRX(RobotMap.rightRoller);
//     //     IntakeR.set(ControlMode.PercentOutput,1);


// }

// public static void armDown() {

//  if(endCountBase == 0 && endCountElbow == 0) {

//      stopMotor();

//  }else {


//     armBase.set(ControlMode.PercentOutput,-0.5);
//     endCountBase = -(armBase.getSelectedSensorPosition(0) /4069);


//      armElbow.set(ControlMode.PercentOutput,-0.5);
//      endCountElbow = -(armElbow.getSelectedSensorPosition(0) /4069);
//     }

// }
// }
