package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

@TeleOp(name="TankDrive", group="A-Team")
public class TankDrive extends OpMode {

    DcMotor leftDrive;
    DcMotor rightDrive;
    DcMotor middleDrive;

    public void init() {

        leftDrive = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        middleDrive = hardwareMap.get (DcMotor.class, "middle_drive");
    }

    public void loop() {

        float lefty = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;
        float middle = gamepad1.right_stick_x;



        leftDrive.setPower(leftY);
        rightDrive.setPower(rigtY);
        middleDrive.setpower(rightX);



        }


    }
}


