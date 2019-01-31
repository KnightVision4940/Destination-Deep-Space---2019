/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/



package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.HIDType;
import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.GenericHID.RumbleType;
/**
 * Add your docs here.
 */
public class Xbox extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

public static XboxController xbox = new XboxController(0);

public static int outputs;

public static int rRumble;

public static int lRumble;



//Triggers

//Why does this exist
// public static boolean getTrigger(Hand hand) {
//   return false;
// }


//Choose this one
public static double getTriggerAxis (Hand hand) {
  if (hand.equals(Hand.kLeft)) {
    return xbox.getRawAxis(2);
  } else {
    return xbox.getRawAxis(3);
  }
}

//Or this one for driving
public static double getTriggers(){
  if(xbox.getRawAxis(2) > xbox.getRawAxis(3)){
    return xbox.getRawAxis(2);
  } else {
    return -xbox.getRawAxis(3);
  }
}

//Left Stick

// public static double getY(Hand hand) {
//   if (hand.equals(Hand.kLeft)) {
//     return xbox.getRawAxis(1);
//   } else {
//     return xbox.getRawAxis(5);
//   }
  
// }

//Simplified version of Above
public static double getYLeft(){
  return xbox.getRawAxis(0);
}


// public static double getx(Hand hand) {
// if (hand.equals(Hand.kLeft)) {
//   return xbox.getRawAxis(0);
// } else {
//   return xbox.getRawAxis(5);
// }
// }
public static double getXLeft(){
  return xbox.getRawAxis(1);
}

public static boolean getTop(Hand hand) {
  return false;
}

//Bumpers

public static boolean getBumper(Hand hand) {
  if (hand.equals(Hand.kLeft)) {
    return xbox.getRawButton(5);
  } else {
    return xbox.getRawButton(6);}}

//Buttons

public static boolean getRawButton(Hand hand) {
  return xbox.getStickButton (hand);
}

public static boolean getAButton() {
  return xbox.getRawButton(1);
}

public static boolean getBButton() {
  return xbox.getRawButton(2);
}

public static boolean getXButton() {
  return xbox.getRawButton(3);
}

public static boolean getYButton() {
  return xbox.getRawButton(4);
}

public static boolean getStickButton(Hand hand) {
  if (hand.equals(Hand.kLeft)) {
    return xbox.getRawButton(9);
  } else {
    return xbox.getRawButton(10);
  }
}

//Probably won't need these next two buttons
public static boolean getBackButton() {
  return xbox.getRawButton(7);
}

public static boolean getStartButton() {
  return xbox.getRawButton(8);
}

//Stick POV (D-Pad)

//Don't need this line - it was creating errors
// public static boolean getRawButton(Hand hand) {
//   return false;
// }

//This part was repeated
// public static boolean getStickButton(Hand hand) {
//   if (hand.equals(Hand.kLeft)) {
//     return xbox.getRawButton(9);
//   } else {
//     return xbox.getRawButton(10);
//   }
// }

public static int getPOV(int pov) {
  return getStickPOV(pov);
}

public static int getStickPOV(final int pov) {
return 0;
}
public static int getPOVCount() {
  return getStickPOVCount() ;
}

public static int getStickPOVCount() {
return 0;
}

//Joystick?? - Why??

//I don't know what this is
// public static int getJoystickType() {
// return 0;
// }

public static HIDType getType() {
  //return HIDType.values()[getJoystickType()];
  return xbox.getType();
}


public static String getNameXBox() {
  //return getJoystickName();
  return xbox.getName();
}

public static String getJoystickName() {
return null;
}

//Outputs - I don't know what these are. If we get errors, you can uncomment thiss - Gabriel

/*Review later
public static void setOutput(int outputNumber, boolean value) {
  outputs = (outputs & ~(1 << (outputNumber - 1))) | ((value ? 1 : 0) << (outputNumber - 1));
  HAL.setJoystickOutputs((byte) outputs, lRumble, rRumble, rRumble);
}

public static void setOutputs(int value) {
  outputs = value;
  HAL.setJoystickOutputs((byte)  outputs, lRumble, rRumble, rRumble);
}
*/

//Rumble

//Lots of Errors Here: 
// public static void setRumble(RumbleType type, double value) {
//   if (value < 0) {
//     value = 0;
//   } else if (value > 1) {
//     value = 1;
//   }
//   if (type == RumbleType.kLeftRumble) {
//     m_leftRumble = (short) (value * 65535);
//   } else {
//     m_rightRumble = (short) (value * 65535);
//   }
//   HAL.setJoystickOutputs((byte) m_outputs, m_leftRumble, m_rightRumble, m_rightRumble);
// }

 @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  } 
}
