// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
public class Drivetrain extends SubsystemBase {
    private final TalonFX leftLeader = new TalonFX(Constants.Drivetrain.LeftLeaderID);
    private final TalonFX leftFollower = new TalonFX(Constants.Drivetrain.LeftFollowerID);
    private final TalonFX rightLeader = new TalonFX(Constants.Drivetrain.RightLeaderID);
    private final TalonFX rightFollower = new TalonFX(Constants.Drivetrain.RightFollowerID);

  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {
    // leftFollower.setControl(new Follower(leftLeader.getDeviceID(), false));
    // rightFollower.setControl(new Follower(rightLeader.getDeviceID(), false));
  }

  @Override
  public void periodic() {
  }

  /**
   * Drive the robot drivetrain
   * 
   * @param forwardSpeed how fast the robot accelerates forward
   * @param turnSpeed how fast the robot rotates it's heading
   */
  public void drive(double forwardSpeed, double turnSpeed)
  {
    System.out.println(forwardSpeed);
    leftFollower.set(TalonFXControlMode.Velocity, turnSpeed+forwardSpeed);
    leftLeader.set(TalonFXControlMode.Velocity, turnSpeed+forwardSpeed);
    rightLeader.set(TalonFXControlMode.Velocity, turnSpeed-forwardSpeed);
    rightFollower.set(TalonFXControlMode.Velocity, turnSpeed-forwardSpeed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
