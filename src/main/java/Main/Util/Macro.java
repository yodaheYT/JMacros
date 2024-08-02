package Main.Util;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Instructions.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Macro {
    public List<Instruction> Instructions;
    public Keyboard keyboard;
    public Mouse mouse;
    public RuntimeController runtimeController;
    public Thread thread;
    public boolean playing = false;

    public Macro() {
        keyboard = new Keyboard();
        mouse = new Mouse();
        runtimeController = new RuntimeController();
        Instructions = new ArrayList<>();
    }

    public void addInstruction(Instruction instruction) {
        Instructions.add(instruction);
    }

    public void addInstruction(String name, int data) {
        switch (name) {
            case "ClickKey":
                Instructions.add(new ClickKey(data));
                break;
            case "PressKey":
                Instructions.add(new PressKey(data));
                break;
            case "ReleaseKey":
                Instructions.add(new ReleaseKey(data));
                break;
            case "Wait":
                Instructions.add(new Wait(data));
                break;
            case "JumpToMouse":
                Instructions.add(new JumpToMouse(data));
                break;
        }
    }

    public void run(JMenuItem runButton, JButton runButton2) {
        playing = true;
        thread = new Thread(() -> {
            for (Instruction instruction : Instructions) {
                instruction.run(keyboard, mouse, runtimeController);
            }
            playing = false;
            runButton.setText("Run");
            runButton2.setText("Run");
        });
        thread.start();
    }
    public void stop() {
        playing = false;
        thread.interrupt();
        thread = null;
    }
}
