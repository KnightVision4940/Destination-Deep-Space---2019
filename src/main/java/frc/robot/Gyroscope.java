/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.SPI;
/**
 * Add your docs here.
 */
public class Gyroscope {
    ADXRS450_Gyro gyro;

    Gyroscope(){
        SPI.Port kGyroPort = SPI.Port.kOnboardCS0;
        gyro = new ADXRS450_Gyro(kGyroPort);
    }

    int getAngle(){
       return (int)gyro.getAngle();
    }

    void reset(){
        gyro.reset();
      }
      
    void calibrategyro(){
        gyro.calibrate();
      }
}
