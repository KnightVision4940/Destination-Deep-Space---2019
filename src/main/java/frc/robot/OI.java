/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.*;
//import frc.robot.Xbox;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Climb;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public static final Joystick xBox = new Joystick(1);
  public static final XboxController x = new XboxController(1);
  public static final XboxController l = new XboxController(3);
  public static final Joystick logicTech = new Joystick(3);
  
  public OI(){
    Button xbox_a = new JoystickButton(xBox,1);
    Button xbox_b = new JoystickButton(xBox,2);
    Button xbox_x = new JoystickButton(xBox,3);
    Button xbox_y = new JoystickButton(xBox,4);

    Button logi_a = new JoystickButton(logicTech, 1);
    Button logi_b = new JoystickButton(logicTech, 2);
    Button logi_x = new JoystickButton(logicTech, 3);
    Button logi_y = new JoystickButton(logicTech, 4);
    Button logi_LB = new JoystickButton(logicTech, 5);
    Button logi_RB = new JoystickButton(logicTech, 6);
    
    
   


    
    xbox_a.whenPressed(new HatchesGrab());
    xbox_b.whileHeld(new HatchesDrop());
    xbox_x.whileHeld(new HatchesInit());
    xbox_y.whenPressed(new ClimbBot());
   
    logi_b.whenPressed(new ArmGrab());
    logi_LB.whenPressed(new IntakeOut());
    logi_RB.whenPressed(new IntakeIn());


   // a.whenReleased(new IntakeIn(true));
  


  
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
  return x.getRawAxis(0);
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