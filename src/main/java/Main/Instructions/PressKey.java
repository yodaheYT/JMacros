package Main.Instructions;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Util.Instruction;

public class PressKey extends Instruction {
    public PressKey(int key) {
        super("PressKey", "Pushes a Key Down", key);
        this.dataName = "Key";
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {
        keyboard.PressKey(this.data);
    }
}
