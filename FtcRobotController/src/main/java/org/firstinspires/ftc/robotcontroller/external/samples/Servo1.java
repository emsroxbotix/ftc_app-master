package org.firstinspires.ftc.robotcontroller.external.samples;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name = "servo thing", group = "Group1")
@Disabled
public class Servo1 extends LinearOpMode {
    static final double INCREMENT   = 0.01;
    static final int    CYCLE_MS    =   50;
    static final double MAX_POS     =  1.0;
    static final double MIN_POS     =  0.0;
    Servo   servoa;
    double  position = (MAX_POS - MIN_POS) / 2;
    boolean rampUp = true;
    @Override
    public void runOpMode() {
        servoa = hardwareMap.get(Servo.class, "eServo");
        if(gamepad1.a){
            if (rampUp == true) {
                position += INCREMENT ;
                if (position >= MAX_POS ) {
                    position = MAX_POS;
                    rampUp = !rampUp;
                }
            }
        }
        if(gamepad1.b){
            if (rampUp == false){
                position -= INCREMENT ;
                if (position >= MIN_POS){
                    position = MIN_POS;
                    rampUp = !rampUp;
                }
            }
        }
    }
}