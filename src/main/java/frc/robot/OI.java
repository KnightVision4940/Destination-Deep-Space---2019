/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;



import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.commands.*;
//import frc.robot.Xbox;
import frc.robot.subsystems.Arm;

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
  
  public OI(){
    Button a = new JoystickButton(xBox,1);
    Button b = new JoystickButton(xBox,2);
    Button x = new JoystickButton(xBox,3);
    Button y = new JoystickButton(xBox,4);
    
    if(Robot.A_Control.getPOV(1) == 0){
      wrist.start(0.5);
    }else if(Robot.A_Control.getPOV(1) == 180){
      wrist.start(-0.5);
    }else if(Robot.A_Control.getPOV(1) == -1){
      wrist.cancel();



    
    a.whileHeld(new IntakeIn());
    b.whileHeld(new IntakeOut());
    x.whileHeld(new HatchesGrab());
    y.whileHeld(new HatchesDrop());

   // a.whenReleased(new IntakeIn(true));
  }


  
}
}