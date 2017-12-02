package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
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
    public Servo linearServo;
    public DcMotor glyphUpDown;
    public DcMotor leftDriveFront;
    public DcMotor rightDriveFront;
    public Servo jewel;
    public Servo jewelRetract;
    public CRServo relicGrabber;
    public DcMotor relicUp;
    public DcMotor relicSlide;
    public ColorSensor colorDetect;

    HardwareMap hwMap;

    public Motors() {



    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;
        leftDrive = hwMap.get(DcMotor.class, "Motor2");
        rightDrive = hwMap.get(DcMotor.class, "Motor3");
        slide = hwMap.get(DcMotor.class, "Motor5");
        glyph1 = hwMap.get(Servo.class, "Servo1");
        glyph2 = hwMap.get(Servo.class, "Servo2");
        linearServo = hwMap.get(Servo.class, "LinearServo1");
        glyphUpDown = hwMap.get(DcMotor.class, "GlyphUp");
        leftDriveFront = hwMap.get(DcMotor.class, "Motor1");
        rightDriveFront = hwMap.get(DcMotor.class, "Motor4");
        jewel = hwMap.get(Servo.class, "jewelServo");
        jewelRetract = hwMap.get(Servo.class, "jewelRetract");
        relicGrabber = hwMap.get(CRServo.class, "relicGrab");
        relicUp = hwMap.get(DcMotor.class, "relicUp");
        relicSlide = hwMap.get(DcMotor.class, "relicSlide");
        colorDetect = hwMap.get(ColorSensor.class, "color");

        leftDrive.setPower(0);
        rightDrive.setPower(0);
        slide.setPower(0);

    }

}
