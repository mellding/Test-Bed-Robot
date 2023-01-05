package frc.robot;

public final class Constants {
       
    
    public static final int     PIGEONIMU_CAN_ID            = 9;
    public static final int     LEFT_MOTOR_1_CAN_ID         = 10;
    public static final int     LEFT_MOTOR_2_CAN_ID         = 11;
    public static final int     RIGHT_MOTOR_1_CAN_ID        = 12;
    public static final int     RIGHT_MOTOR_2_CAN_ID        = 13;

    public static final int     DRIVE_MOTOR_MAX_CURRENT     = 39;
    public static final double  DRIVETRAIN_RAMP_RATE        = .5;
    public static final int     ENCOCDER_CPR                = 4096;
    public static final double  DRIVE_WHEEL_DIA_IN          = 6.0;
    public static final double  DRIVE_WHEEL_CIRC_IN         = DRIVE_WHEEL_DIA_IN * Math.PI;
    public static final double  DRIVE_WHEEL_CIRC_FT         = DRIVE_WHEEL_CIRC_IN / 12;
    public static final double  DRIVE_BASE_WIDTH_IN         = 26.0;
    public static final boolean DRIVETRAIN_INVERTED         = true;
    public static final double  SLOW_DRIVE_MAX              = .5;
    public static final double  DRIVE_CLOSED_LOOP_DEADZONE  = 200;

    public static final double  CLOSED_LOOP_RAMP_RATE       = 1;
    
    public static final double  FEEDFORWARD_KS              = 0;
    public static final double  FEEDFORWARD_KV              = 0;
    public static final double  FEEDFORWARD_KA              = 0;

    public static final double  LEFT_DRIVE_KP               = 1;
    public static final double  LEFT_DRIVE_KI               = 0;
    public static final double  LEFT_DRIVE_KD               = 0;

    public static final double  RIGHT_DRIVE_KP              = 1;
    public static final double  RIGHT_DRIVE_KI              = 0;
    public static final double  RIGHT_DRIVE_KD              = 0;

    public static final int     CONTROLLER1_PORT            = 0;
    
    
    public static final int     MAX_TA_ENTRIES              = 50;

}
