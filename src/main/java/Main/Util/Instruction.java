package Main.Util;

import Main.Controllers.Keyboard;
import Main.Controllers.Mouse;
import Main.Controllers.RuntimeController;

public class Instruction {
    public String name;
    public String description;
    public int data;
    public int data2;

    public String dataName = "data";
    public String data2Name = "";

    public Instruction(String newName, String newDescription, int newData) {
        name = newName;
        description = newDescription;
        data = newData;
    }

    public void run(Keyboard keyboard, Mouse mouse, RuntimeController runtimeController) {

    }
}
