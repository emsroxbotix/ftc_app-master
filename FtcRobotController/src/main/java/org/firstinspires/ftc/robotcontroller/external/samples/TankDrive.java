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

    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor spin;
    DcMotor shooter;

    public void init() {

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        spin = hardwareMap.get(DcMotor.class, "spinner");
        shooter = hardwareMap.get(DcMotor.class, "cannon");
    }

    public void loop() {

        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;

        float cannon = -gamepad2.right_trigger;
        boolean spinner = gamepad2.right_bumper;
        boolean spinnero = gamepad2.left_bumper;


        leftDrive.setPower(leftY);
        rightDrive.setPower(rightY);


        if (spinner) {

            spin.setPower(1);

        } else if (spinnero) {

            spin.setPower(-1);

        } else {

            spin.setPower(0);

        }

        if (cannon < 0) {

            shooter.setPower(0.5);

        } else {

            shooter.setPower(0);

        }

        // hello world! i may or may not be a comment
        // plz dont kill meh
        // plzplzplzplzplzplzplzplzplzplz
        // i didnt do anything wrong D:D:D:D:D:D:D:D:D:D:D:D:D:D:
    }
}


