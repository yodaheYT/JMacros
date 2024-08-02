package Main.Instructions;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Util.Clock;
import Main.Util.Instruction;

public class UnpressMouse extends Instruction {
    Clock clock;

    public UnpressMouse(int key) {
        super("UnpressMouse", "Releases the mouse", key);
        this.dataName = "Button";
        clock = new Clock();
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {
        mouse.Unpress(this.data);
    }
}