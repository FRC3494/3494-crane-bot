// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Drivetrain extends SubsystemBase {
  private final TalonSRX leftLeader = new TalonSRX(Constants.Drivetrain.LeftLeaderID);
  private final TalonSRX leftFollower = new TalonSRX(Constants.Drivetrain.LeftFollowerID);
  private final TalonSRX rightLeader = new TalonSRX(Constants.Drivetrain.RightLeaderID);
  private final TalonSRX rightFollower = new TalonSRX(Constants.Drivetrain.RightFollowerID);

  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {

  }

  @Override
  public void periodic() {
  }

  /**
   * Drive the robot drivetrain
   * 
   * @param forwardSpeed how fast the robot accelerates forward
   * @param turnSpeed    how fast the robot rotates it's heading
   */
  public void drive(double forwardSpeed, double turnSpeed) {
    System.out.println("Forward speed: " + forwardSpeed);
    System.out.println("Turn Speed: (positive -> right)" + turnSpeed);
    leftFollower.set(TalonSRXControlMode.PercentOutput, forwardSpeed - turnSpeed);
    leftLeader.set(TalonSRXControlMode.PercentOutput, forwardSpeed - turnSpeed);
    rightLeader.set(TalonSRXControlMode.PercentOutput, -(forwardSpeed + turnSpeed));
    rightFollower.set(TalonSRXControlMode.PercentOutput, -(forwardSpeed + turnSpeed));
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
