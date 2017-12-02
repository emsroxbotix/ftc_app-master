package org.firstinspires.ftc.robotcontroller.external.samples;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import static java.lang.Thread.sleep;


public class AutonEncoderDrive extends LinearOpMode {
    
    Motors motor = new Motors();

    private ElapsedTime runtime = new ElapsedTime();

    static final double COUNTS_PER_MOTOR_REV = 538;    // eg: TETRIX Motor Encoder
    static final double DRIVE_GEAR_REDUCTION = 1.0;     // This is < 1.0 if geared UP
    static final double WHEEL_DIAMETER_INCHES = 4.0;     // For figuring circumference
    static final double COUNTS_PER_INCH = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) /
            (WHEEL_DIAMETER_INCHES * 3.1415);
    static final double DRIVE_SPEED = 0.25;
    static final double TURN_SPEED = 0.125;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does spall the work here
         try message to signify robot waiting; */
        motor.init(hardwareMap);
        telemetry.addData("Status", "Resetting Encoders");    //
        telemetry.update();


        motor.leftDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.rightDrive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.rightDriveFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.leftDriveFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        idle();

        motor.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.leftDriveFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.rightDriveFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Send telemetry message to indicate successful Encoder reset
        telemetry.addData("Path0", "Starting at %7d :%7d",
                motor.leftDrive.getCurrentPosition(),
                motor.rightDrive.getCurrentPosition());

        telemetry.addData("encoderPosLeft", motor.leftDrive.getCurrentPosition());
        telemetry.addData("encoderPosRight", motor.rightDrive.getCurrentPosition());

        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        //commenty comment


        // Step through each leg of the path,
        // Note: Reverse movement is obtained by setting a negative distance (not speed)

        sleep(100);


        telemetry.update();

        encoderDrive(DRIVE_SPEED, -28, 36   , 30.0);

        // pause for servos to move

        //telemetry.addData("Path", "Complete");
        //telemetry.update();
    }

    /*
     *  Method to perfmorm a relative move, based on encoder counts.
     *  Encoders are not reset as the move is based on the current position.
     *  Move will stop if any of three conditions occur:
     *  1) Move gets to the desired position
     *  2) Move runs out of time
     *  3) Driver stops the opmode running.
     */
    public void encoderDrive(double speed,
                             double leftInches, double rightInches,
                             double timeoutS) {
        int newLeftTarget;
        int newRightTarget;
        int newRight2;
        int newLeft2;

        // Ensure that the opmode is still active
        if (opModeIsActive()) {

            // Determine new target position, and pass to motor controller
            newLeftTarget = motor.leftDrive.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newRightTarget = motor.rightDrive.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);
            newRight2 = motor.rightDriveFront.getCurrentPosition() + (int) (leftInches * COUNTS_PER_INCH);
            newLeft2 = motor.leftDriveFront.getCurrentPosition() + (int) (rightInches * COUNTS_PER_INCH);

            motor.leftDrive.setTargetPosition(newLeftTarget);
            motor.rightDrive.setTargetPosition(newRightTarget);
           // motor.leftDriveFront.setTargetPosition(newLeftTarget);
            //motor.rightDriveFront.setTargetPosition(newRightTarget);

            // Turn On RUN_TO_POSITION
            motor.leftDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            motor.rightDrive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            //motor.rightDriveFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            //motor.leftDriveFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            // reset the timeout time and start motion.
            runtime.reset();
            motor.leftDrive.setPower(Math.abs(.25));
            motor.rightDrive.setPower(Math.abs(.25));
            //motor.leftDriveFront.setPower(Math.abs(.25));
            //motor.rightDriveFront.setPower(Math.abs(.25));

            // keep looping while we are still active, and there is time left, and both motors are running.
            while (opModeIsActive() &&
                    (runtime.seconds() < timeoutS) &&
                    (motor.leftDrive.isBusy() && motor.rightDrive.isBusy())) {

                // Display it for the driver.
                telemetry.addData("Path1", "Running to %7d :%7d", newLeftTarget, newRightTarget);
                telemetry.addData("Path2", "Running at %7d :%7d",
                        motor.leftDrive.getCurrentPosition(),
                        motor.rightDrive.getCurrentPosition());

                telemetry.update();
            }

            // Stop all motion;
            motor.leftDrive.setPower(0);
            motor.rightDrive.setPower(0);
           // motor.rightDriveFront.setPower(0);
            //motor.leftDriveFront.setPower(0);

            // Turn off RUN_TO_POSITION
            motor.leftDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            motor.rightDrive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //motor.leftDriveFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            //motor.rightDriveFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            //  sleep(250);   // optional pause after each move
        }
    }

}

    /* public void distanceSensor() {

        double distanceReading = distance.getLightDetected();

        telemetry.addData("Distance Sensor", "In the function");

        // 8========8 whats up, im a comment

        while  (distanceReading <= 0) {

            telemetry.addData("Distance Sensor", "Less than 8cm");
            telemetry.update();

            if (indexer.getPosition() == 0.0) {

                indexer.setPosition(1.0);

                sleep(3000);

            } else if (indexer.getPosition() == 1.0) {

                indexer.setPosition(0.0);

                sleep(3000);

            }

        }

        telemetry.update();

    }

    public void touchSensor() {


        telemetry.addData("Touch Sensor", "in the function");
        telemetry.addData("Servo Position", indexer.getPosition());

        while (touch.isPressed()) {

            telemetry.addData("Touch Sensor", "Is pressed");

            if (indexer.getPosition() == 0.0) {

                indexer.setPosition(1.0);

                sleep(3000);

            } else if (indexer.getPosition() == 1.0) {

                indexer.setPosition(0.0);

                sleep(3000);

            }

        }

    }
    */

