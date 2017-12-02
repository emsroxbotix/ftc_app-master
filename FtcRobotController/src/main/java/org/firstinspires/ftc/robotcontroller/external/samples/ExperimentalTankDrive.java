package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Tejas Mehta on 11/21/16.
 */
@TeleOp(name="DankDrive", group="A-Team")
public class ExperimentalTankDrive extends OpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor slide;
    ElapsedTime time = new ElapsedTime();

    Motors motor = new Motors();

    public void init() {

        motor.init(hardwareMap);

    }

    public void loop() {

        float leftY = gamepad1.right_stick_y;
        float rightY = -gamepad1.left_stick_y;
        float slider = gamepad1.right_stick_x;

        motor.leftDrive.setPower(leftY/4);
        motor.leftDriveFront.setPower(leftY/4);
        motor.rightDrive.setPower(rightY/4);
        motor.rightDriveFront.setPower(rightY/4);

        motor.slide.setPower(-(gamepad1.left_stick_x + gamepad1.right_stick_x)/8);

        motor.glyphUpDown.setPower(-gamepad2.left_stick_y);


    }
}


