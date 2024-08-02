package Main.Instructions;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Util.Clock;
import Main.Util.Instruction;

public class ClickMouse extends Instruction {
    Clock clock;

    public ClickMouse(int key) {
        super("ClickMouse", "Presses and releases the mouse", key);
        this.dataName = "Button";
        clock = new Clock();
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {
        mouse.Press(this.data);
        clock.sleep(200);
        mouse.Unpress(this.data);
    }
}