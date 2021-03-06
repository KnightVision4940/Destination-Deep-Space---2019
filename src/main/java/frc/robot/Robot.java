/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Drive;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ManualArmControl;
import frc.robot.commands.WristMove;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.Hatches;
import frc.robot.subsystems.IntakeSystem;
import frc.robot.subsystems.PracticeMotor;
import frc.robot.subsystems.TurnTable;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static ExampleSubsystem m_subsystem = new ExampleSubsystem();
  public static OI m_oi;
  //PracticeMotor pmotor = new PracticeMotor();
  public static PracticeMotor Practice = new PracticeMotor();
  public static Hatches H = new Hatches();
  public static IntakeSystem intakeSystem = new IntakeSystem();
  public static Arm arm = new Arm();
  public static Climb Climb = new Climb();  
  public static TurnTable table = new TurnTable();
  public static Gyroscope gyro = new Gyroscope();
  public static Wrist wrist = new Wrist();
  public static boolean ran = false;
  public static final XboxController x = new XboxController(1);
  public static final XboxController l = new XboxController(3);
  public static double deadband = 0.15;

  public static DriveTrain driveTrain = new DriveTrain(RobotMap.frontLeft, RobotMap.frontRight, RobotMap.backLeft, RobotMap.backRight);
  Command m_autonomousCommand;
  //Drive drive = new Drive();
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    SmartDashboard.putData("Auto mode", m_chooser);
    CamServer.camInit();
    // gyro.gyroInit();
    // gyro.calibrategyro();
    // gyro.reset();
    Climb.setEncoder();
    m_oi = new OI();
   // new UpdateDashboard();
    
        
  
   // System.out.println(isOperatorControl() + " " + isEnabled());
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
    Scheduler.getInstance().add(new Drive());
    Scheduler.getInstance().add(new frc.robot.commands.TurnTable());
    Scheduler.getInstance().add(new WristMove());
    Scheduler.getInstance().add(new ManualArmControl());
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
    Scheduler.getInstance().add(new Drive());
    Scheduler.getInstance().add(new frc.robot.commands.TurnTable());
    Scheduler.getInstance().add(new ManualArmControl());
    Scheduler.getInstance().add(new WristMove());
    //CamServer.camStop();
    //drive.start();
  }
    public static void startCommand(){
      Scheduler.getInstance().add(new WristMove());
      ran = true;
    }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    
  }
  public static double getGyro(){
    return gyro.getAngle();
  }
  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
  
public static double getTriggers(){
  if(x.getRawAxis(2) > x.getRawAxis(3)){
    return x.getRawAxis(2);
  } else {
    return -x.getRawAxis(3);
  }

}
public static int getPOV(){
return l.getPOV();
}

public static double getTriggersLogi(){
if(l.getRawAxis(2) > l.getRawAxis(3)){
  return l.getRawAxis(2);
} else {
  return -l.getRawAxis(3);
}

}
public static double getX(){
  double xaxis = x.getRawAxis(0);
  // if(xaxis > deadband && xaxis < -deadband){
    return x.getRawAxis(0);
  // }else{
  //   return 0;
  // }

}
public static double getYLogiL(){
return l.getRawAxis(1);
}
public static double getYLogiR(){
return l.getRawAxis(5);
}
public static double getXLogi(){
return l.getRawAxis(0);
}
}
