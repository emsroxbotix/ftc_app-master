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
    int motorSpeedDiv = 2;
    // boolean sliderValue1 = false;
    // boolean sliderValue2 = false;
    boolean driverMode = false;



    public void init() {

        motors.init(hardwareMap);

    }

    public void loop() {


        // float slider = (gamepad1.right_stick_x + gamepad1.left_stick_x)/4;
        float rightTrigger = gamepad2.right_trigger;
        float leftTrigger = gamepad2.left_trigger;
        float glyphUpDown = gamepad2.left_stick_y;
        motors.jewelRetract.setPosition(0.0);

        motors.jewel.setPosition(0.2);

        // Speed Functions: Certain buttons are mapped to
        // certain speed levels. The higher the number, the slower
        // the robot goes.

        if (gamepad1.right_bumper){
            motorSpeedDiv = 4;
            telemetry.addData("drive speed", motorSpeedDiv);
        } else if (gamepad1.left_bumper){
            motorSpeedDiv = 8;
            telemetry.addData("drive speed", motorSpeedDiv);
        } else if (gamepad1.a){
            motorSpeedDiv = 2;
            telemetry.addData("drive speed", motorSpeedDiv);
        }


        motors.relicSlide.setPower(gamepad2.right_stick_x);
        motors.relicUp.setPower(gamepad2.right_stick_y/4);




        // motors.leftDrive.setPower(gamepad1.left_stick_y/2);
        // motors.leftDriveFront.setPower(gamepad1.left_stick_y/2);
        // motors.rightDrive.setPower(gamepad2.right_stick_y/2);
        // motors.rightDrive.setPower(gamepad2.right_stick_y/2);






        /*


        telemetry.addData("motor_speed", motorSpeedDiv);

        if (gamepad1.left_bumper){
            motorSpeedDiv = 4;
            telemetry.addData("motor_speed", motorSpeedDiv);
        }
        if (gamepad1.right_bumper){
            motorSpeedDiv = 8;
            telemetry.addData("motor_speed", motorSpeedDiv);
        }


        motors.leftDrive.setPower(gamepad1.left_stick_y/2);
        motors.leftDriveFront.setPower(gamepad1.left_stick_y/2);
        motors.rightDrive.setPower(gamepad2.right_stick_y/2);
        motors.rightDrive.setPower(gamepad2.right_stick_y/2);
        */



        motors.jewelRetract.setPosition(rightTrigger);

        if (gamepad1.x) {

            driverMode = false;
            telemetry.addData("drive_mode", "Arcade Drive");

        } else if (gamepad1.y) {

            driverMode = true;
            telemetry.addData("drive_mode", "Tank Drive");

        }

        if (driverMode == false) {

            float yValue = gamepad1.left_stick_y;
            float xValue = gamepad1.left_stick_x;

            telemetry.addData("drive_mode", "Arcade Drive");
            telemetry.update();
            float leftPower =  yValue + xValue;
            float rightPower = yValue - xValue;

            motors.leftDrive.setPower(Range.clip(leftPower/motorSpeedDiv, -1.0, 1.0));
            motors.rightDrive.setPower(Range.clip(-rightPower/motorSpeedDiv, -1.0, 1.0));
            motors.rightDriveFront.setPower(Range.clip(-rightPower/motorSpeedDiv, -1.0, 1.0));
            motors.leftDriveFront.setPower(Range.clip(leftPower/motorSpeedDiv, -1.0, 1.0));
            motors.slide.setPower(-gamepad1.right_stick_x/motorSpeedDiv);



        } else {

            float leftY = gamepad1.right_stick_y;
            float rightY = -gamepad1.left_stick_y;

            telemetry.addData("drive_mode", "Arcade Drive");
            telemetry.update();

            motors.leftDrive.setPower(leftY / motorSpeedDiv);
            motors.leftDriveFront.setPower(leftY / motorSpeedDiv);
            motors.rightDrive.setPower(rightY / motorSpeedDiv);
            motors.rightDriveFront.setPower(rightY / motorSpeedDiv);

            motors.slide.setPower(-(gamepad1.left_stick_x + gamepad1.right_stick_x) / (motorSpeedDiv * 2));

        }

        if (true) {
            if (gamepad1.dpad_down){

                motors.leftDrive.setPower(Range.clip(1, -1.0, 1.0));
                motors.rightDrive.setPower(Range.clip(-1, -1.0, 1.0));
                motors.rightDriveFront.setPower(Range.clip(-1, -1.0, 1.0));
                motors.leftDriveFront.setPower(Range.clip(1, -1.0, 1.0));

            }
            if (gamepad1.dpad_up){

                motors.leftDrive.setPower(Range.clip(-1, -1.0, 1.0));
                motors.rightDrive.setPower(Range.clip(1, -1.0, 1.0));
                motors.rightDriveFront.setPower(Range.clip(1, -1.0, 1.0));
                motors.leftDriveFront.setPower(Range.clip(-1, -1.0, 1.0));

            }
            if (gamepad1.dpad_left){

                motors.slide.setPower(1);

            }
            if (gamepad1.dpad_right){

                motors.slide.setPower(-1);

            }

        }



        /*


        */

        if (-glyphUpDown > 0.01) {

            motors.glyphUpDown.setPower(-glyphUpDown/3);

        } else if (-glyphUpDown < 0.01) {

            motors.glyphUpDown.setPower(-glyphUpDown/32);

        }

        //motors.glyph1.setPosition(rightTrigger);
        //motors.glyph2.setPosition(1 - rightTrigger);
        //motors.glyph1.setPosition(1 - leftTrigger);
        //motors.glyph2.setPosition(leftTrigger);




        if (gamepad2.left_bumper) {

            motors.glyph1.setPosition(0.3);
            motors.glyph2.setPosition(0.7);

        } else if (gamepad2.left_trigger > 0) {

            motors.glyph1.setPosition(0);
            motors.glyph2.setPosition(1);

        }


        telemetry.update();

        motors.linearServo.setPosition(gamepad2.right_trigger);

        motors.relicGrabber.setPower(gamepad2.left_stick_x);



    }
}


