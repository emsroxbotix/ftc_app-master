package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by steamuser on 12/2/2017.
 */

public class EncoderTest extends LinearOpMode {

    Motors motor = new Motors();
    boolean isBlue;
    boolean isRed;
    boolean none;

    private ElapsedTime runtime = new ElapsedTime();

    static final double COUNTS_PER_MOTOR_REV = 538;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.25;
    static final double TURN_SPEED = 0.125;

    @Override
    public void runOpMode(){



        motor.init(hardwareMap);


        waitForStart();


        motor.jewel.setPosition(0.65);
        motor.jewel.setPosition(0.7);
        motor.jewel.setPosition(0.75);
        motor.jewel.setPosition(0.8);
        motor.jewel.setPosition(0.85);
        motor.jewel.setPosition(0.9);


        sleep(3000);

        if (motor.colorDetect.red() - motor.colorDetect.blue() >= 75) {

            isRed = true;
            isBlue = false;
            none = false;

        } else if (motor.colorDetect.blue() - motor.colorDetect.red() >= 75) {

            isBlue = true;
            isRed = false;
            none = false;

        } else {

            isBlue = false;
            isRed = false;
            none = true;

        }


        if (none) {

            motor.jewel.setPosition(0.2);

        } else if (isRed) {

            motor.leftDriveFront.setPower(-0.5);
            motor.rightDriveFront.setPower(-0.5);
            motor.rightDrive.setPower(0.5);
            motor.leftDrive.setPower(0.5);
            sleep(1000);
            motor.jewel.setPosition(0.2);
        } else if (isBlue) {

            motor.leftDriveFront.setPower(0.5);
            motor.rightDriveFront.setPower(0.5);
            motor.rightDrive.setPower(-0.5);
            motor.leftDrive.setPower(-0.5);
            sleep(1000);
            motor.jewel.setPosition(0.2);

        }





    }
}
