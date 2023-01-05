package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.sensors.PigeonIMU;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class DriveTrainSubsystem extends SubsystemBase {

  private static WPI_TalonSRX   left1     = new WPI_TalonSRX(Constants.LEFT_MOTOR_1_CAN_ID);
  private static WPI_VictorSPX  left2     = new WPI_VictorSPX(Constants.LEFT_MOTOR_2_CAN_ID);
  private static WPI_TalonSRX   right1    = new WPI_TalonSRX(Constants.RIGHT_MOTOR_1_CAN_ID);
  private static WPI_VictorSPX  right2    = new WPI_VictorSPX(Constants.RIGHT_MOTOR_2_CAN_ID);
  private static PigeonIMU      pigeon    = new PigeonIMU(Constants.PIGEONIMU_CAN_ID);

  public DriveTrainSubsystem() {

    //Restore Factory defaults to get right of any previously stored settings
    left1.configFactoryDefault();   left2.configFactoryDefault();
    right1.configFactoryDefault();  right2.configFactoryDefault();

    //Set the secondary motors to follow the primary motors
    left2.follow(left1);  right2.follow(right1);

    //Set the motor ramp rate: time in seconds to go from 0 to full throttle
    left1.configOpenloopRamp(Constants.DRIVETRAIN_RAMP_RATE);
    right1.configOpenloopRamp(Constants.DRIVETRAIN_RAMP_RATE);

    //Set the default neutral mode to coast
    left1.setNeutralMode(NeutralMode.Coast);  left2.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast); right2.setNeutralMode(NeutralMode.Coast);

    //Set the motors left and right motors to in opposite directions
    left1.setInverted(Constants.DRIVETRAIN_INVERTED);left2.setInverted(Constants.DRIVETRAIN_INVERTED);
    right1.setInverted(!Constants.DRIVETRAIN_INVERTED);right2.setInverted(!Constants.DRIVETRAIN_INVERTED);

    //Configure the encoder feedback device
    left1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    right1.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);

    left1.setSensorPhase(true);right1.setSensorPhase(true);

    left1.setSelectedSensorPosition(0);right1.setSelectedSensorPosition(0);
    
    left1.config_kP(0, Constants.LEFT_DRIVE_KP);
    left1.config_kI(0, Constants.LEFT_DRIVE_KI);
    left1.config_kD(0, Constants.LEFT_DRIVE_KD);
    right1.config_kP(0, Constants.RIGHT_DRIVE_KP);
    right1.config_kI(0, Constants.RIGHT_DRIVE_KI);
    right1.config_kD(0, Constants.RIGHT_DRIVE_KD);

    pigeon.configFactoryDefault();

  }

  public void setLeftMotors(double power){
    left1.setNeutralMode(NeutralMode.Coast);left2.setNeutralMode(NeutralMode.Coast);
    left1.configOpenloopRamp(Constants.DRIVETRAIN_RAMP_RATE);
    left1.set(ControlMode.PercentOutput,power);
  }

  public void setRightMotors(double power){
    right1.setNeutralMode(NeutralMode.Coast); right2.setNeutralMode(NeutralMode.Coast);
    right1.configOpenloopRamp(Constants.DRIVETRAIN_RAMP_RATE);
    right1.set(ControlMode.PercentOutput,power);
  }

  public void setMotors(double lPower, double rPower){
    left1.setNeutralMode(NeutralMode.Coast);left2.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);right2.setNeutralMode(NeutralMode.Coast);
    left1.configOpenloopRamp(Constants.DRIVETRAIN_RAMP_RATE);
    right1.configOpenloopRamp(Constants.DRIVETRAIN_RAMP_RATE);
    left1.set(ControlMode.PercentOutput,lPower); right1.set(ControlMode.PercentOutput,rPower);
  }

  public void gtaDrive(double rBumper, double lBumper, double turn){
    left1.setNeutralMode(NeutralMode.Coast);left2.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);right2.setNeutralMode(NeutralMode.Coast);
    left1.configOpenloopRamp(Constants.DRIVETRAIN_RAMP_RATE);
    right1.configOpenloopRamp(Constants.DRIVETRAIN_RAMP_RATE);
    setMotors((rBumper - lBumper) - turn, (rBumper - lBumper) + turn);
  }

  public void setMotorsRAM(double lPower, double rPower){
    left1.setNeutralMode(NeutralMode.Coast);left2.setNeutralMode(NeutralMode.Coast);
    right1.setNeutralMode(NeutralMode.Coast);right2.setNeutralMode(NeutralMode.Coast);
    left1.configOpenloopRamp(0);
    right1.configOpenloopRamp(0);
    left1.set(ControlMode.PercentOutput,lPower); right1.set(ControlMode.PercentOutput,rPower);
  }

  public void setBrake(){
    left1.setNeutralMode(NeutralMode.Brake);left2.setNeutralMode(NeutralMode.Brake);
    right1.setNeutralMode(NeutralMode.Brake);right2.setNeutralMode(NeutralMode.Brake);
    left1.configOpenloopRamp(0);
    right1.configOpenloopRamp(0);
    left1.set(ControlMode.PercentOutput,0); right1.set(ControlMode.PercentOutput,0);
  }

  public void setReverse(){
    left1.setInverted(!left1.getInverted());left2.setInverted(!left1.getInverted());
    right1.setInverted(!right1.getInverted());right2.setInverted(!right1.getInverted());
  }

  public double getYaw(){
    return pigeon.getYaw();
  }

  @Override
  public void periodic() {

  }
}
