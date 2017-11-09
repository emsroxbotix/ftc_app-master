package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


/**
 * Created by tejasmehta on 11/9/17.
 */

@Autonomous
public class Tests extends OpMode {

    ColorSensorClass jewelTest = new ColorSensorClass();

    @Override
    public void init() {

        jewelTest.init(hardwareMap);


    }

    @Override
    public void loop() {

        jewelTest.RedCheck(1.0);

        telemetry.addData("Num", jewelTest.color_sensor.alpha());
        telemetry.addData("Red", jewelTest.color_sensor.red());
        telemetry.update();

    }


}
