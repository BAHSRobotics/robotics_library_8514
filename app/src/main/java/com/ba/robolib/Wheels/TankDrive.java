package com.ba.robolib.Wheels;

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
    private DcMotor[] wheelsArray = new DcMotor[4];

    /**
     * Maps 4 motors to the software. Necessary to use all other methods.
     *
     * @param hardwareMap     A hardware map that will be populated with all 4 wheels
     * @param rightFrontMotor The name of the motor, as specified in the config, positioned on the right front side as viewed from the top of the robot.
     * @param leftFrontMotor  The name of the motor, as specified in the config, positioned on the left front side as viewed from the top of the robot.
     * @param rightBackMotor  The name of the motor, as specified in the config, positioned on the right back side as viewed from the top of the robot.
     * @param leftBackMotor   The name of the motor, as specified in the config, positioned on the left back side as viewed from the top of the robot.
     **/
    public void mapWheels(HardwareMap hardwareMap, String rightFrontMotor, String rightBackMotor, String leftFrontMotor, String leftBackMotor) {
        wheelsArray[0] = hardwareMap.dcMotor.get(rightFrontMotor);
        wheelsArray[1] = hardwareMap.dcMotor.get(rightBackMotor);
        wheelsArray[2] = hardwareMap.dcMotor.get(leftFrontMotor);
        wheelsArray[3] = hardwareMap.dcMotor.get(leftBackMotor);
    }

    /**
     * Maps 2 motors to the software. Necessary to use all other methods.
     *
     * @param hardwareMap A hardware map that will be populated with all 4 wheels
     * @param rightMotor  The name of the motor, as specified in the config, positioned on the right side as viewed from the top of the robot.
     * @param leftMotor   The name of the motor, as specified in the config, positioned on the left side as viewed from the top of the robot.
     **/
    public void mapWheels(HardwareMap hardwareMap, String rightMotor, String leftMotor) {
        wheelsArray[0] = hardwareMap.dcMotor.get(rightMotor);
        wheelsArray[1] = null;
        wheelsArray[2] = hardwareMap.dcMotor.get(leftMotor);
        wheelsArray[3] = null;
    }

    /**
     * Sets wheel directions
     **/
    public void setDirections() {
        wheelsArray[0].setDirection(DcMotor.Direction.REVERSE);
        wheelsArray[1].setDirection(DcMotor.Direction.REVERSE);
        wheelsArray[2].setDirection(DcMotor.Direction.FORWARD);
        wheelsArray[3].setDirection(DcMotor.Direction.FORWARD);
    }

    /**
     * Moves all wheels in the same direction
     *
     * @param power The absolute motor power
     **/
    public void moveWheels(double power) {
        for (DcMotor aWheelsArray : wheelsArray) {
            aWheelsArray.setPower(power * -1);
        }
    }

    /**
     * Turns the robot about its center point
     *
     * @param power      The absolute motor power
     * @param wheelGroup A string describing which direction to turn.
     **/
    public void moveWheels(double power, String wheelGroup) {
        switch (wheelGroup) {
            case "right":
                wheelsArray[0].setPower(-power);
                wheelsArray[1].setPower(-power);
                wheelsArray[2].setPower(power);
                wheelsArray[3].setPower(power);
                break;
            case "left":
                wheelsArray[0].setPower(power);
                wheelsArray[1].setPower(power);
                wheelsArray[2].setPower(-power);
                wheelsArray[3].setPower(-power);
                break;
        }
    }

    /**
     * Stops all 4 wheels of the robot
     **/
    public void stopWheels() {
        for (DcMotor aWheelsArray : wheelsArray) {
            aWheelsArray.setPower(0);
        }
    }
}