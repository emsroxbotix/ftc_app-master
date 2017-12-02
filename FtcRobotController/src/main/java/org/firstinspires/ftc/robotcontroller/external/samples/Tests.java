package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.hardware.ams.AMSColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.I2cWaitControl;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;




@Autonomous
public class Tests extends OpMode {

    //ColorSensorClass jewelTest = new ColorSensorClass();
    //TouchSensorClass touchTest = new TouchSensorClass();
    Servo linearServo;
    CRServo continuousServo;
    double nameOfDouble;
    int waiter;

    @Override
    public void init() {

        //jewelTest.init(hardwareMap);
        //touchTest.init(hardwareMap);
        linearServo = hardwareMap.get(Servo.class, "LinearServo");
        continuousServo = hardwareMap.get(CRServo.class, "ContinuousServo");


    }

    @Override
    public void loop() {

        continuousServo.setPower(-gamepad2.left_stick_y);

        linearServo.setPosition(gamepad2.right_trigger);

        //linearServo.setPosition(gamepad2.right_stick_y);

        /*
        if (-gamepad2.left_stick_y >= 0.05){
            nameOfDouble = nameOfDouble + 0.1;
        } else if (-gamepad2.left_stick_y <= -0.05){
            nameOfDouble = nameOfDouble - 0.1;
        }
        linearServo.setPosition(nameOfDouble);

        */

        //jewelTest.RedCheck(1.0);
        //telemetry.addData("Blue", jewelTest.isBlue);
        //telemetry.addData("None", jewelTest.none);
        //telemetry.update();
    }


}
