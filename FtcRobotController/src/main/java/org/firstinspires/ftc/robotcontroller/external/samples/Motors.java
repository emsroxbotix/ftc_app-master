package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by steamuser on 11/14/2017.
 */

public class Motors {

    public DcMotor leftDrive;
    public DcMotor rightDrive;
    public DcMotor slide;
    public Servo glyph1;
    public Servo glyph2;

    HardwareMap hwMap;

    public Motors() {



    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;
        leftDrive = hwMap.get(DcMotor.class, "Motor2");
        rightDrive = hwMap.get(DcMotor.class, "Motor3");
        slide = hwMap.get(DcMotor.class, "Motor1");
        glyph1 = hwMap.get(Servo.class, "Servo1");
        glyph2 = hwMap.get(Servo.class, "Servo2");

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        slide.setPower(0);

    }

}
