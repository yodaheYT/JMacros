package Main.Instructions;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Util.Clock;
import Main.Util.Instruction;

public class ClickKey extends Instruction {
    Clock clock;

    public ClickKey(int key) {
        super("ClickKey", "Presses and releases a key", key);
        this.dataName = "Key";
        clock = new Clock();
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {
        keyboard.PressKey(this.data);
        clock.sleep(200);
        keyboard.ReleaseKey(this.data);
    }
}