package com.yangshm.designpattern.demo05;

import com.yangshm.designpattern.demo05.command.Command;
import com.yangshm.designpattern.demo05.command.NoCommond;

public class RemoteController {
    Command[] onCommands;
    Command[] offCommands;
    Command undoCommand;

    public RemoteController() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommond = new NoCommond();
        for (int i = 0; i < 7; i++) {
            onCommands[i] = noCommond;
            offCommands[i] = noCommond;
        }
        undoCommand = noCommond;
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = onCommand;
    }

    public void buttonOn(int slot) {
        onCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void buttonOff(int slot) {
        offCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void buttonBack() {
        undoCommand.execute();
    }
}
