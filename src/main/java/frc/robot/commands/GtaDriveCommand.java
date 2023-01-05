// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class GtaDriveCommand extends CommandBase {

  DriveTrainSubsystem driveTrain;
  XboxController controller1;
  double lTrigger;
  double rTrigger;
  double turn;

  /** Creates a new GtaDriveCommand. */
  public GtaDriveCommand(DriveTrainSubsystem driveTrain, XboxController controller1) {
    this.driveTrain = driveTrain;
    this.controller1 = controller1;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    lTrigger = controller1.getLeftTriggerAxis();
    rTrigger = controller1.getRightTriggerAxis();
    turn = controller1.getLeftY();
    driveTrain.gtaDrive(rTrigger, lTrigger, turn);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
