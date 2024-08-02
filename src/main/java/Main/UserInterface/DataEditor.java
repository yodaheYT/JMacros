package Main.UserInterface;

import Main.Util.Instruction;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DataEditor extends JPanel {
    public DefaultTableModel model = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column)
        {
            if (column == 1) {
                return true;
            }
            return false;
        }
    };
    public JTable table;
    public JButton delete;
    public JButton save;
    public DataEditor() {
        super();
        this.setBorder(new CompoundBorder(new TitledBorder("Properties"), new EmptyBorder(4, 4, 4, 4)));
        this.setLayout(new GridLayout(3, 1));
        table = new JTable(model);

        model.addColumn("Property");
        model.addColumn("Value");

        model.addRow(new Object[] {"Data1", "null"});
        model.addRow(new Object[] {"Data2", "null"});
        this.add(table);

        save = new JButton("Save");
        delete = new JButton("Delete");
        this.add(save);
        this.add(delete);
    }

    public void change(MacroList macroList) {
        try {
            Instruction i = macroList.items.get(macroList.getSelectedIndex());
            switch (i.name) {
                case "Wait":
                    model.setValueAt(i.dataName, 0, 0);
                    model.setValueAt(i.data, 0, 1);
                    model.setValueAt("", 1, 0);
                    model.setValueAt("", 1, 1);
                    break;
                case "ClickKey":
                case "PressKey":
                case "ReleaseKey":
                    model.setValueAt(i.dataName, 0, 0);
                    model.setValueAt((char) i.data, 0, 1);
                    model.setValueAt("", 1, 0);
                    model.setValueAt("", 1, 1);
                    break;
                default:
                    if (i.data2Name.equals("")) {
                        model.setValueAt(i.dataName, 0, 0);
                        model.setValueAt(i.data, 0, 1);
                        model.setValueAt("", 1, 0);
                        model.setValueAt("", 1, 1);
                    } else {
                        model.setValueAt(i.dataName, 0, 0);
                        model.setValueAt(i.data, 0, 1);
                        model.setValueAt(i.data2Name, 1, 0);
                        model.setValueAt(i.data2, 1, 1);
                    }
                    break;
            }
        } catch (Exception e) {
            System.out.println("Failed to update DataEditor!");
        }
    }
}
