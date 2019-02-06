/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.cameraserver.*;
import edu.wpi.cscore.UsbCamera;
/**
 * Add your docs here.
 */
public class CamServer {
    
	public static UsbCamera m_Cam;
	
	public static void camInit(){
		m_Cam = CameraServer.getInstance().startAutomaticCapture("vision", 0);
		m_Cam.setFPS(30);
		m_Cam.setResolution(320, 240);
		m_Cam.setExposureManual(50);
	}
	
}
