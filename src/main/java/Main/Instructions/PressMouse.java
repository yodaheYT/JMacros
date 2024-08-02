package Main.Instructions;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Util.Clock;
import Main.Util.Instruction;

public class PressMouse extends Instruction {
    Clock clock;

    public PressMouse(int key) {
        super("PressMouse", "Presses the mouse", key);
        this.dataName = "Button";
        clock = new Clock();
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {
        mouse.Press(this.data);

    }
}