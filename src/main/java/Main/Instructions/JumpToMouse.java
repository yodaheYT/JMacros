package Main.Instructions;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Util.Instruction;
import Main.Util.Tuple;

public class JumpToMouse extends Instruction {
    public JumpToMouse(int key) {
        super("JumpToMouse", "Jumps the mouse to a position", key);
        this.dataName = "posX";
        this.data2Name = "posY";
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {
        mouse.JumpTo(new Tuple<>(this.data, this.data2));
    }
}
