package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Tejas Mehta on 11/21/16.
 */
@TeleOp(name="TankDrive", group="A-Team")
public class TankDrive extends OpMode {


    Motors motors = new Motors();
    double recentMotorStep = 0;
    double rightMotorStep = 0;
    double leftMotorStep = 0;



    public void init() {

        motors.init(hardwareMap);

    }

    public void loop() {

        float slider = gamepad1.right_stick_x;
        float rightTrigger = gamepad1.right_trigger;
        float leftTrigger = gamepad1.left_trigger;

        motors.slide.setPower(-slider);

        float yValue = gamepad1.left_stick_y;
        float xValue = gamepad1.left_stick_x;

        float leftPower =  yValue - xValue;
        float rightPower = yValue + xValue;

        motors.leftDrive.setPower(Range.clip(leftPower, -1.0, 1.0));
        motors.rightDrive.setPower(Range.clip(rightPower, -1.0, 1.0));

        //motors.glyph1.setPosition(rightTrigger);
        //motors.glyph2.setPosition(1 - rightTrigger);
        //motors.glyph1.setPosition(1 - leftTrigger);
        //motors.glyph2.setPosition(leftTrigger);

        if (motors.glyph1.getPosition() + motors.glyph2.getPosition() == 1) {

            if (rightTrigger > 0) {

                //motors.glyph1.setPosition(rightTrigger);
                //motors.glyph2.setPosition(1 - rightTrigger);

                motors.glyph1.setPosition(rightMotorStep);
                motors.glyph2.setPosition(1 - rightMotorStep);

                recentMotorStep=recentMotorStep+0.05;


            } if (leftTrigger > 0) {

                //motors.glyph1.setPosition(1 - leftTrigger);
                //motors.glyph2.setPosition(leftTrigger);

                motors.glyph1.setPosition(1 - leftMotorStep);
                motors.glyph2.setPosition(leftMotorStep);

                recentMotorStep=recentMotorStep-0.05;

            }

        } else {

            motors.glyph1.setPosition(0);
            motors.glyph2.setPosition(1);

        }
        recentMotorStep = recentMotorStep-1;

/*
        if (leftY > 0) {

            if (leftX > 0) {



            }

            motors.leftDrive.setPower(-leftY);
            rightDrive.setPower(leftY);

        } else if (leftY < 0) {

            motors.leftDrive.setPower(-leftY);
            rightDrive.setPower(leftY);

        } else if (leftY == 0) {

            motors.leftDrive.setPower(leftY);
            motors.rightDrive.setPower(leftY);

        }
        */

    }
}


