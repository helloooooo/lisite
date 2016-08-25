package com.bruce.design_pattern.chapter5;

/**
 * Created by wuteng1 on 2016/7/31.
 */
public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public RemoteControl() {
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommands = new NoCommand();
        for(int i = 0; i < onCommands.length; i++){
            onCommands[i] = noCommands;
            offCommands[i] = noCommands;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand){
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }
    public void onButtonPushed(int slot){
        if(slot >= 0 && slot < onCommands.length){
            onCommands[slot].execute();
        }
    }

    public void offButtonPushed(int slot){
        if(slot >= 0 && slot < offCommands.length){
            offCommands[slot].execute();
        }
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n---------Remote Control---------------\n");
        for(int i = 0; i < onCommands.length; i++){
            stringBuffer.append("[ slot " + i + " ] " + onCommands[i].getClass().getName() +
                                    "   " + offCommands[i].getClass().getName() + "\n");
        }
        return stringBuffer.toString();

    }
}
