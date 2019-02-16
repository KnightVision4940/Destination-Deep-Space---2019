/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
//steven wuz here
package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
/**
 * Add your docs here.
 */
public class Dashboard {
    public static void board(){
        
        //Time Left
        double time = 1;
        time = DriverStation.getInstance().getMatchTime();
        SmartDashboard.putNumber("time left", time);

        //Gyro
        Gyroscope g = new Gyroscope();
        int gyro = g.getAngle();
        SmartDashboard.putNumber("gyro angle", gyro);

        //Arm Angle = Baseangle
        Arm a = new Arm();
        double Baseangle =  a.endCountBase;
        SmartDashboard.putNumber("angle of Base", Baseangle);
        
        //Arm Angle = ArmElbow
         double ArmElbow = a.endCountElbow;
        SmartDashboard.putNumber("angle of Elbow",ArmElbow); 

        // Arm Angle = ArmWaist
        double ArmWaist = a.endCountWrist;
        SmartDashboard.putNumber("angle of Waist",ArmWaist);
        
        //Robot Status  
       

}

}