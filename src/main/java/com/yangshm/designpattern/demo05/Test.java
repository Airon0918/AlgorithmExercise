package com.yangshm.designpattern.demo05;

import com.yangshm.designpattern.demo05.command.LightOffCommand;
import com.yangshm.designpattern.demo05.command.LightOnCommand;
import com.yangshm.designpattern.demo05.device.Light;

public class Test {
    public static void main(String[] args) {
        RemoteController remoteController = new RemoteController();

        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);

        remoteController.setCommand(0, lightOnCommand, lightOffCommand);
        remoteController.buttonOn(0);
    }
}
