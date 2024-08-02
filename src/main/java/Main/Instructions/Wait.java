package Main.Instructions;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;
import Main.Util.Clock;
import Main.Util.Instruction;

public class Wait extends Instruction {
    Clock clock;
    public Wait(int key) {
        super("Wait", "Waits x milliseconds", key);
        clock = new Clock();
        this.dataName = "Milliseconds";
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {
        clock.sleep(this.data);
    }
}