package Main.Instructions;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Util.Clock;
import Main.Util.Instruction;

public class Scroll extends Instruction {
    Clock clock;

    public Scroll(int key) {
        super("Scroll", "Scrolls the mouse", key);
        this.dataName = "Notches";
        clock = new Clock();
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {
        mouse.scroll(this.data, true);

    }
}