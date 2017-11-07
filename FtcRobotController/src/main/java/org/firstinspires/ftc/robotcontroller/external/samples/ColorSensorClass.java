package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by steamuser on 11/7/2017.
 */

public class ColorSensorClass {

    ColorSensor color_sensor;

    HardwareMap hwMap;

    Servo jewel;

    public ColorSensorClass() {



    }


    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        color_sensor = hwMap.colorSensor.get("color");



    }

    public void RedCheck(double ServoPos) {

        if (color_sensor.alpha() == color_sensor.red()) {


            jewel.setPosition(ServoPos);


        } else {



        }

    }




}
