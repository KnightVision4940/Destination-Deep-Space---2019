/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package frc.robot;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.HIDType;
import edu.wpi.first.wpilibj.GenericHID.Hand;
//import edu.wpi.first.wpilibj.GenericHID.RumbleType;
/**
 * Add your docs here.
 */
public class Xbox{
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static XboxController xbox;
public Xbox(int port){
  xbox = new XboxController(port);
}




//  XboxController xbox2 = new XboxController(2);

  int outputs;

  int rRumble;

  int lRumble;



//Triggers

//Why does this exist
//   boolean getTrigger(Hand hand) {
//   return false;
// }


//Choose this one
  double getTriggerAxis (Hand hand) {
  if (hand.equals(Hand.kLeft)) {
    return xbox.getRawAxis(2);
  } else {
    return xbox.getRawAxis(3);
  }
}

//Or this one for driving
  double getTriggers(){
  if(xbox.getRawAxis(2) > xbox.getRawAxis(3)){
    return xbox.getRawAxis(2);
  } else {
    return -xbox.getRawAxis(3);
  }
}

//Left Stick

//   double getY(Hand hand) {
//   if (hand.equals(Hand.kLeft)) {
//     return xbox.getRawAxis(1);
//   } else {
//     return xbox.getRawAxis(5);
//   }
  
// }

//Simplified version of Above
  double getYLeft(){
  return xbox.getRawAxis(1);
}


//   double getx(Hand hand) {
// if (hand.equals(Hand.kLeft)) {
//   return xbox.getRawAxis(0);
// } else {
//   return xbox.getRawAxis(5);
// }
// }
  double getXLeft(){
  return xbox.getRawAxis(0);
}

  boolean getTop(Hand hand) {
  return false;
}

//Bumpers

  boolean getBumper(Hand hand) {
  if (hand.equals(Hand.kLeft)) {
    return xbox.getRawButton(5);
  } else {
    return xbox.getRawButton(6);}}

//Buttons

  boolean getRawButton(Hand hand) {
  return xbox.getStickButton (hand);
}

  boolean getAButton() {
  return xbox.getRawButton(1);
}

  boolean getBButton() {
  return xbox.getRawButton(2);
}

  boolean getXButton() {
  return xbox.getRawButton(3);
}

  boolean getYButton() {
  return xbox.getRawButton(4);
}

  boolean getStickButton(Hand hand) {
  if (hand.equals(Hand.kLeft)) {
    return xbox.getRawButton(9);
  } else {
    return xbox.getRawButton(10);
  }
}

//Probably won't need these next two buttons
  boolean getBackButton() {
  return xbox.getRawButton(7);
}

  boolean getStartButton() {
  return xbox.getRawButton(8);
}

//Stick POV (D-Pad)

//Don't need this line - it was creating errors
//   boolean getRawButton(Hand hand) {
//   return false;
// }

//This part was repeated
//   boolean getStickButton(Hand hand) {
//   if (hand.equals(Hand.kLeft)) {
//     return xbox.getRawButton(9);
//   } else {
//     return xbox.getRawButton(10);
//   }
// }

  int getPOV(int pov) {
  return xbox.getPOV();
}

 

//Joystick?? - Why??

//I don't know what this is
//   int getJoystickType() {
// return 0;
// }

  HIDType getType() {
  //return HIDType.values()[getJoystickType()];
  return xbox.getType();
}


  String getNameXBox() {
  //return getJoystickName();
  return xbox.getName();
}

  String getJoystickName() {
return null;
}

//Outputs - I don't know what these are. If we get errors, you can uncomment thiss - Gabriel

/*Review later
  void setOutput(int outputNumber, boolean value) {
  outputs = (outputs & ~(1 << (outputNumber - 1))) | ((value ? 1 : 0) << (outputNumber - 1));
  HAL.setJoystickOutputs((byte) outputs, lRumble, rRumble, rRumble);
}

  void setOutputs(int value) {
  outputs = value;
  HAL.setJoystickOutputs((byte)  outputs, lRumble, rRumble, rRumble);
}
*/

//Rumble

//Lots of Errors Here: 
//   void setRumble(RumbleType type, double value) {
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

 
}