package Main.UserInterface;

import Main.Instructions.ClickKey;
import Main.Instructions.PressKey;
import Main.Instructions.ReleaseKey;
import Main.Instructions.Wait;
import Main.Util.Instruction;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.util.ArrayList;
import java.util.List;

public class MacroList extends JList {
    public List<Instruction> items = new ArrayList<>();
    public DefaultListModel model = new DefaultListModel();
    public MacroList() {
        super();
        this.setModel(model);
        this.setBorder(new CompoundBorder(new TitledBorder("Macro Instructions"), new EmptyBorder(4, 4, 4, 4)));


    }

    public void AddMacro(Instruction instruction) {
        items.add(instruction);
        model.add(model.size(), instruction.name);
        /*switch (instruction.name) {
            case "Wait":
                model.add(model.size(), instruction.name + " | " + instruction.data + "ms");
                break;
            default:
                model.add(model.size(), instruction.name + " | " + (char)instruction.data);
                break;
        }*/
        this.setSelectedIndex(model.size()-1);
    }
}

