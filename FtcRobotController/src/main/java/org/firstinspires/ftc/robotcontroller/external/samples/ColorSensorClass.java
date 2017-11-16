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
    boolean isBlue;
    boolean none;

    public ColorSensorClass() {



    }


    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;
        color_sensor = hwMap.colorSensor.get("color");
        jewel = hwMap.get(Servo.class, "jewelServo");



    }

    public boolean RedCheck(double ServoPos) {


        if (color_sensor.red() - color_sensor.blue() >= 100) {

            isBlue = false;
            none = false;
            jewel.setPosition(ServoPos);
            return isBlue;


        } else if (color_sensor.blue() - color_sensor.red() >= 200){

            isBlue = true;
            none = false;
            jewel.setPosition(0.5);
            return isBlue;

        } else {

            none = true;
            isBlue = false;
            jewel.setPosition(0.0);
            return none;


        }

    }




}
