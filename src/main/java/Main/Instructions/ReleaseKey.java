package Main.Instructions;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Util.Instruction;

public class ReleaseKey extends Instruction {
    public ReleaseKey(int key) {
        super("ReleaseKey", "Releases a key", key);
        this.dataName = "Key";
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {
        keyboard.ReleaseKey(this.data);
    }
}
