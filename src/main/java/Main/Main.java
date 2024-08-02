package Main;

import Main.Instructions.*;
import Main.UserInterface.DataEditor;
import Main.UserInterface.MacroList;
import Main.UserInterface.MenuBar;
import Main.UserInterface.Toolbar;
import Main.Util.DataHandler;
import Main.Util.Instruction;
import Main.Util.Macro;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class Main {
    public static Macro macro = null;
    public Macro testMacro() {
        Macro macro = new Macro();

        macro.addInstruction("Wait", 1000);
        macro.addInstruction("ClickKey", KeyEvent.VK_A);
        //macro.run();
        return macro;
    }

    public static void main(String[] args) {
        // Setup DarkLaf
        FlatDarkLaf.setup();


        // Setup JFrame
        JFrame frame = new JFrame("JMacros");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(new ImageIcon(Objects.requireNonNull(Main.class.getClassLoader().getResource("logo.png"))).getImage());

        // Create MenuBar
        MenuBar menuBar = new MenuBar();
        frame.setJMenuBar(menuBar);

        // Create GridBagConstraints
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        frame.setLayout(new GridBagLayout());

        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.05;
        gridBagConstraints.gridx = 0;

        // Create Toolbar
        Toolbar toolBar = new Toolbar();

        // Set GBC to the Toolbar
        gridBagConstraints.gridy = 0;
        frame.getContentPane().add(toolBar, gridBagConstraints);

        // Create MacroList
        MacroList macroList = new MacroList();

        // Set GBC to the MacroList
        gridBagConstraints.weighty = 0.95;
        gridBagConstraints.weightx = 0.75;
        gridBagConstraints.gridy = 1;
        frame.getContentPane().add(macroList, gridBagConstraints);

        // Create Add Events
        menuBar.JMacrosComponents.forEach(component -> {
            component.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int data = 1;
                    /*try {
                        String input = JOptionPane.showInputDialog("Enter a value for " + component.getText() + ".");

                        try {
                            int d = Integer.parseInt(input);
                            data = d;
                        } catch (Exception exception) {
                            data = input.charAt(0);
                        }
                    } catch (Exception exception) {
                        System.out.println("Input not valid");
                    }*/
                    switch (component.getText()) {
                        case "ClickKey":
                            macroList.AddMacro(new ClickKey(data));
                            break;
                        case "PressKey":
                            macroList.AddMacro(new PressKey(data));
                            break;
                        case "ReleaseKey":
                            macroList.AddMacro(new ReleaseKey(data));
                            break;
                        case "Wait":
                            macroList.AddMacro(new Wait(data));
                            break;
                        case "JumpToMouse":
                            macroList.AddMacro(new JumpToMouse(data));
                            break;
                        case "MoveToMouse":
                            macroList.AddMacro(new MoveToMouse(data));
                            break;
                        case "ClickMouse":
                            macroList.AddMacro(new ClickMouse(data));
                            break;
                        case "PressMouse":
                            macroList.AddMacro(new PressMouse(data));
                            break;
                        case "UnpressMouse":
                            macroList.AddMacro(new UnpressMouse(data));
                            break;
                        case "Scroll":
                            macroList.AddMacro(new Scroll(data));
                            break;
                    }
                }
            });
        });
        menuBar.JMacrosMenuRun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuBar.JMacrosMenuProtectedRun.getState()) {
                    try {
                        if (macro == null) {
                            macro = new Macro();
                            macroList.items.forEach(instruction -> {
                                macro.addInstruction(instruction);
                            });
                            macro.run(menuBar.JMacrosMenuRun, toolBar.ToolbarStart);
                            menuBar.JMacrosMenuRun.setText("Stop");
                            toolBar.ToolbarStart.setText("Stop");
                        } else {
                            macro.stop();
                            macro = null;
                            menuBar.JMacrosMenuRun.setText("Run");
                            toolBar.ToolbarStart.setText("Run");
                        }
                    } catch (Exception exception) {
                        System.out.println("Macro Error");
                    }
                } else {
                    if (macro == null) {
                        macro = new Macro();
                        macroList.items.forEach(instruction -> {
                            macro.addInstruction(instruction);
                        });
                        macro.run(menuBar.JMacrosMenuRun, toolBar.ToolbarStart);
                        menuBar.JMacrosMenuRun.setText("Stop");
                        toolBar.ToolbarStart.setText("Stop");
                    } else {
                        macro.stop();
                        macro = null;
                        menuBar.JMacrosMenuRun.setText("Run");
                        toolBar.ToolbarStart.setText("Run");
                    }
                }
            }
        });
        toolBar.ToolbarStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (menuBar.JMacrosMenuProtectedRun.getState()) {
                    try {
                        if (macro == null) {
                            macro = new Macro();
                            macroList.items.forEach(instruction -> {
                                macro.addInstruction(instruction);
                            });
                            macro.run(menuBar.JMacrosMenuRun, toolBar.ToolbarStart);
                            menuBar.JMacrosMenuRun.setText("Stop");
                            toolBar.ToolbarStart.setText("Stop");
                        } else {
                            macro.stop();
                            macro = null;
                            menuBar.JMacrosMenuRun.setText("Run");
                            toolBar.ToolbarStart.setText("Run");
                        }
                    } catch (Exception exception) {
                        System.out.println("Macro Error");
                    }
                } else {
                    if (macro == null) {
                        macro = new Macro();
                        macroList.items.forEach(instruction -> {
                            macro.addInstruction(instruction);
                        });
                        macro.run(menuBar.JMacrosMenuRun, toolBar.ToolbarStart);
                        menuBar.JMacrosMenuRun.setText("Stop");
                        toolBar.ToolbarStart.setText("Stop");
                    } else {
                        macro.stop();
                        macro = null;
                        menuBar.JMacrosMenuRun.setText("Run");
                        toolBar.ToolbarStart.setText("Run");
                    }
                }
            }
        });

        // Create DataEditor
        DataEditor dataEditor = new DataEditor();

        macroList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                dataEditor.change(macroList);
            }
        });
        dataEditor.save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Instruction oldInstruction = macroList.items.get(macroList.getSelectedIndex());

                    switch (oldInstruction.name) {
                        case "ClickKey":
                        case "PressKey":
                        case "ReleaseKey":
                            oldInstruction.data = dataEditor.model.getValueAt(0, 1).toString().charAt(0);
                            break;
                        default:
                            oldInstruction.data = Integer.parseInt(dataEditor.model.getValueAt(0, 1).toString());
                            if (!oldInstruction.data2Name.equals("")) {
                                oldInstruction.data2 = Integer.parseInt(dataEditor.model.getValueAt(1, 1).toString());
                            }
                            break;
                    }

                    macroList.items.set(macroList.getSelectedIndex(), oldInstruction);
                } catch (Exception exception) {
                    System.out.println("Failed to save!");
                    exception.printStackTrace();
                }
            }
        });
        dataEditor.delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int index = macroList.getSelectedIndex();
                    macroList.items.remove(index);
                    macroList.model.remove(index);
                } catch (Exception exception) {
                    System.out.println("Delete Failed!");
                    exception.printStackTrace();
                }
            }
        });
        toolBar.Clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    macroList.items.clear();
                    macroList.model.clear();
                } catch (Exception exception) {
                    System.out.println("Clear Failed!");
                }
            }
        });
        menuBar.MacroMenuExport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DataHandler.Save(macroList.items, frame);
            }
        });
        menuBar.MacroMenuImport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Instruction> data = DataHandler.Load(frame);
                macroList.items.clear();
                macroList.model.clear();
                assert data != null;
                data.forEach(instruction -> {
                    macroList.items.add(macroList.items.size(), instruction);
                    macroList.model.add(macroList.model.size(), instruction.name);
                });
            }
        });

        // Set GBC to DataEditor
        gridBagConstraints.weightx = 0.25;
        gridBagConstraints.gridx = 1;
        frame.getContentPane().add(dataEditor, gridBagConstraints);

        // Show Window
        frame.pack();
        frame.setVisible(true);
        frame.setSize(750, 300);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
    }
}
