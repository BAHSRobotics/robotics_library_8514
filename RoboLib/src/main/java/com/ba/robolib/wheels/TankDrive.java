package com.ba.robolib.wheels;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
/* TODO: Test functionality on actual robots */
/**
 * Class holding methods to run a robot drive system in tank mode.
 *
 * @author Caleb Trevino
 **/
public class TankDrive {
    /**
     * Array allowing the easy storage of all wheels
     **/
    private DcMotor[] wheels = new DcMotor[4];

    public TankDrive(HardwareMap hardwareMap, String rightFrontMotor, String rightBackMotor, String leftFrontMotor, String leftBackMotor) {
        wheels[0] = hardwareMap.dcMotor.get(rightFrontMotor);
        wheels[1] = hardwareMap.dcMotor.get(rightBackMotor);
        wheels[2] = hardwareMap.dcMotor.get(leftFrontMotor);
        wheels[3] = hardwareMap.dcMotor.get(leftBackMotor);

        wheels[0].setDirection(DcMotor.Direction.REVERSE);
        wheels[1].setDirection(DcMotor.Direction.REVERSE);
        wheels[2].setDirection(DcMotor.Direction.FORWARD);
        wheels[3].setDirection(DcMotor.Direction.FORWARD);
    }

    /**
     * Moves all wheels in the same direction
     *
     * @param power The absolute motor power
     **/
    public void move(double power) {
        for (DcMotor wheel : wheels) {
            wheel.setPower(power * -1);
        }
    }

    /**
     * Turns the robot about its center point
     *
     * @param power      The absolute motor power
     * @param wheelGroup A string describing which direction to turn.
     **/
    public void move(double power, String wheelGroup) {
        switch (wheelGroup) {
            case "right":
                wheels[0].setPower(-power);
                wheels[1].setPower(-power);
                wheels[2].setPower(power);
                wheels[3].setPower(power);
                break;
            case "left":
                wheels[0].setPower(power);
                wheels[1].setPower(power);
                wheels[2].setPower(-power);
                wheels[3].setPower(-power);
                break;
        }
    }

    /**
     * Stops all 4 wheels of the robot
     **/
    public void stop() {
        for (DcMotor wheel : wheels) {
            wheel.setPower(0);
        }
    }
}