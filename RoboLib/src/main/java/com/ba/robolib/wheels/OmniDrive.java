package com.ba.robolib.wheels;

import com.ba.robolib.math.vector.Vector4;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OmniDrive {

  private DcMotor[] wheels = new DcMotor[4];

  public OmniDrive(HardwareMap hardwareMap, String rightFrontMotor, String rightBackMotor, String leftFrontMotor, String leftBackMotor) {
    // Maps hardware
    wheels[0] = hardwareMap.dcMotor.get(rightFrontMotor);
    wheels[1] = hardwareMap.dcMotor.get(rightBackMotor);
    wheels[2] = hardwareMap.dcMotor.get(leftBackMotor);
    wheels[3] = hardwareMap.dcMotor.get(leftFrontMotor);

    // Sets directions
    wheels[0].setDirection(DcMotor.Direction.REVERSE);
    wheels[1].setDirection(DcMotor.Direction.REVERSE);
    wheels[2].setDirection(DcMotor.Direction.FORWARD);
    wheels[3].setDirection(DcMotor.Direction.FORWARD);
  }

  public void move(double power) {
    for (DcMotor wheel: wheels) {
      wheel.setPower(power);
    }
  }

  public void move(double power, Vector4 directions) {
    wheels[0].setPower(directions.getW() * power);
    wheels[1].setPower(directions.getX() * power);
    wheels[2].setPower(directions.getY() * power);
    wheels[3].setPower(directions.getZ() * power);
  }

  public void move(double power, String side) {
    if (side.equals("right")) {
      wheels[0].setPower(power);
      wheels[2].setPower(power);
    } else if (side.equals("left")) {
      wheels[1].setPower(power);
      wheels[3].setPower(power);
    }
  }
  public void stop() {
    for (DcMotor wheel: wheels) {
      wheel.setPower(0);
    }
  }
}
