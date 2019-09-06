package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Robot {

    private DcMotor lDrive, rDrive, lLift, rLift, extension, intake, pivot;
    private Servo hopper;

    private HardwareMap hwMap;

    OpMode opMode;


    public void init(HardwareMap ahwMap, OpMode op) {
        // Save reference to Hardware map
        hwMap = ahwMap;
        opMode = op;

        this.hopper = hwMap.get(Servo.class, "hopper");

        // Define and Initialize Motors
        this.lLift = hwMap.get(DcMotor.class, "lLift");
        this.rLift = hwMap.get(DcMotor.class, "rLift");
        this.extension = hwMap.get(DcMotor.class, "extension");
        this.intake = hwMap.get(DcMotor.class, "intake");
        this.pivot = hwMap.get(DcMotor.class, "pivot");

        this.lDrive  = hwMap.get(DcMotor.class, "LD");
        this.rDrive = hwMap.get(DcMotor.class, "RD");
        lDrive.setDirection(DcMotor.Direction.REVERSE);
        rDrive.setDirection(DcMotor.Direction.FORWARD);

        stop();

        setMotorMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        setMotorMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


    }

    public void setIntakePower(double intakePower){
        intake.setPower(intakePower);
    }

    public void setLiftPower(double liftPower){
        lLift.setPower(liftPower);
        rLift.setPower(-liftPower);
    }

    public void setExtensionPower(double extensionPower){
        extension.setPower(extensionPower);
    }

    public void setPivotPower(double pivotPower){
        pivot.setPower(pivotPower);
    }

    public void setHopperPosition(double hopperPosition){
        hopper.setPosition(hopperPosition);
    }

    public void drive(double lPower, double rPower){
        lDrive.setPower(lPower);
        rDrive.setPower(rPower);
    }


    public void stop(){
        lDrive.setPower(0);
        rDrive.setPower(0);
    }

    public void setMotorMode(DcMotor.RunMode mode) {
        rDrive.setMode(mode);
        lDrive.setMode(mode);
    }
}
