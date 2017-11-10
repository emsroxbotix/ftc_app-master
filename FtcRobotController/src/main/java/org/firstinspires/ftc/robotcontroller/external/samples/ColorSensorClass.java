package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;



/**
 * Created by steamuser on 11/7/2017.
 */

public class ColorSensorClass {

    ColorSensor color_sensor;

    HardwareMap hwMap;

    Servo jewel;
    DcMotor motor3;

    public ColorSensorClass() {



    }


    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;
        color_sensor = hwMap.colorSensor.get("color");
        jewel = hwMap.get(Servo.class, "jewelServo");
        motor3 = hwMap.get(DcMotor.class, "Motor 3");




    }

    public void RedCheck(double ServoPos) {


        if (color_sensor.red() > 200) {

            jewel.setPosition(ServoPos);
            motor3.setPower(10);

        } else {

            jewel.setPosition(0.0);
            motor3.setPower(0.0);

        }

    }




}
