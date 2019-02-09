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
    public static int setpoint;
    public static int error;

    public static int p,i,d = 1;
    public static double integral;
    public static double derivative;

    static Gyroscope g = new Gyroscope();

    public static void runMotor(){
        Xbox shackles = new Xbox(1);
    }
    //     //motor.set(1);
    //   //  if(motor.getSelectedSensorPosition()/4069 <= -1){
    //         setpoint = 1;
    //         error = setpoint - -(motor.getSelectedSensorPosition()/4069); // What is Left = Target - Actual
    //         integral += error*0.02; //0.02 is the # of seconds for everytime this method is used
    //        // derivative = (error - this.previous_error) / .02;
    //         double yeet = p*error + i*integral;
    //        // motor.set(ControlMode.PercentOutput,yeet);
    //     // }else{
    //     //     motor.set(ControlMode.PercentOutput,1);
    //     // }
    //     //System.out.println(shackles.getPOV(1));
    //    System.out.println(yeet);

    public static void driveGyro(double speed, double turn){
        setpoint = (int)(turn * 180);
        error = setpoint - g.getAngle(); // What is Left = Target - Actual
        integral += error*0.02; //0.02 is the # of seconds for everytime this method is used
        double yeet = p*error + i*integral;
       // motor.set(ControlMode.PercentOutput,1);
        System.out.println(yeet);
      }
    
    public static void stopMotor(){
        motor.set(ControlMode.PercentOutput,0);
      //  motor.set(0);
    }
    public static void resetEncoder(){
        motor.setSelectedSensorPosition(0);
    }
}
