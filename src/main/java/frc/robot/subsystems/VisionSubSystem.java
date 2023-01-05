package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.util.ArrayList;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class VisionSubSystem extends SubsystemBase {
  private final NetworkTable limeLightTable;
  private double tv, tx, ty, ta;
  private ArrayList<Double> taList;

  public VisionSubSystem() {
    limeLightTable = NetworkTableInstance.getDefault().getTable("limelight");
    taList = new ArrayList<Double>(Constants.MAX_TA_ENTRIES);
  }

  @Override
  public void periodic() {
    tv = limeLightTable.getEntry("tv").getDouble(0);
    tx = limeLightTable.getEntry("tx").getDouble(0);
    ty = limeLightTable.getEntry("ty").getDouble(0);
    ta = limeLightTable.getEntry("ta").getDouble(0);

    if (taList.size() >= Constants.MAX_TA_ENTRIES) taList.remove(0);
    taList.add(ta);
  }

  public boolean isTargetValid() {return (tv == 1.0);}
  
  public double getTv(){return tv;}
  public double getTx(){return tx;}
  public double getTy(){return ty;}

  public double getTA() {
    double sum = 0;
    for (Double num : taList) sum += num.doubleValue();
    return sum/taList.size();
  }
}
