package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;


/**
 * Created by tejasmehta on 11/9/17.
 */

@Autonomous
public class Tests extends OpMode {

    ColorSensorClass jewelTest = new ColorSensorClass();
    //TouchSensorClass touchTest = new TouchSensorClass();

    @Override
    public void init() {

        jewelTest.init(hardwareMap);
        //touchTest.init(hardwareMap);


    }

    @Override
    public void loop() {
        //telemetry.addData("TouchVal", touchTest.touchSensor.getState());

        jewelTest.RedCheck(1.0);
        telemetry.addData("Blue", jewelTest.isBlue);
        telemetry.addData("None", jewelTest.none);
        telemetry.update();


    }


}
