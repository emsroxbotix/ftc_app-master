package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


/**
 * Created by tejasmehta on 11/9/17.
 */

@Autonomous
public class Tests extends OpMode {

    ColorSensorClass jewelTest = new ColorSensorClass();
    TouchSensorClass touchTest = new TouchSensorClass();

    @Override
    public void init() {

        jewelTest.init(hardwareMap);
        touchTest.init(hardwareMap);


    }

    @Override
    public void loop() {

        jewelTest.RedCheck(1.0);
        touchTest.TouchCheck(1.0);

        telemetry.addData("TouchVal", touchTest.touchSensor.getState());

        telemetry.addData("ColorVal", jewelTest.color_sensor.alpha());
        telemetry.addData("RedVal", jewelTest.color_sensor.red());
        telemetry.addData("BlueVal", jewelTest.color_sensor.blue());
        telemetry.update();

    }


}
