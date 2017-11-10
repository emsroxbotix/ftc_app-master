package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by tejasmehta on 11/10/17.
 */

public class TouchSensorClass {

    DigitalChannel touchSensor;

    HardwareMap hwMap;

    DcMotor motor3;

    public TouchSensorClass(){



    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;
        touchSensor = hwMap.get(DigitalChannel.class,"TouchSensor");
        motor3 = hwMap.get(DcMotor.class, "Motor 3");


    }

    public void TouchCheck(double motorPower) {

        if (touchSensor.getState()) {

            motor3.setPower(0.0);

        } else {

            motor3.setPower(motorPower);

        }

    }



}
