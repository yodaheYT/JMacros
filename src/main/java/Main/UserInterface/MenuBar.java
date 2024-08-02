package Main.UserInterface;

import Main.InstructionList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class MenuBar extends JMenuBar {
    public JMenu JMacrosMenu;

    public JMenuItem JMacrosMenuRun;
    public JCheckBoxMenuItem JMacrosMenuProtectedRun;

    public JMenuItem JMacrosAbout;

    public JMenu JMacrosAddComponent;
    public List<JMenuItem> JMacrosComponents;
    public JMenuItem JMacrosMousePosition;

    public JMenu MacroMenu;

    public JMenuItem MacroMenuExport;
    public JMenuItem MacroMenuImport;

    public MenuBar(JFrame frame) {
        super();

        // Create JMacrosMenu
        JMacrosMenu = new JMenu("JMacros");
        JMacrosMenu.setMnemonic(KeyEvent.VK_A);
        JMacrosMenu.getAccessibleContext().setAccessibleDescription(
                "JMacros");
        this.add(JMacrosMenu);

        JMacrosAbout = new JMenuItem("About JMacros");
        JMacrosMenu.add(JMacrosAbout);

        JMacrosAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "JMacros v0.0.1\nDeveloped by yodaheyt\n©2024 yodaheyt.github.io | GNU GPLv3.0\nSupport server: https://yodaheyt.github.io/discord", "About JMacros", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Create Run Button
        JMacrosMenuRun = new JMenuItem("Run", KeyEvent.VK_R);
        JMacrosMenuRun.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_R, ActionEvent.ALT_MASK));
        JMacrosMenuRun.getAccessibleContext().setAccessibleDescription(
                "Runs the current macro");
        JMacrosMenu.add(JMacrosMenuRun);

        JMacrosMousePosition = new JMenuItem("Mouse Position Finder");
        JMacrosMenu.add(JMacrosMousePosition);

        JMacrosMousePosition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        JDialog jDialog = new JDialog();
                        JLabel jLabel = new JLabel("Mouse Position: " + MouseInfo.getPointerInfo().getLocation().x + ", " + MouseInfo.getPointerInfo().getLocation().y);
                        jDialog.getContentPane().add(jLabel);
                        jDialog.pack();
                        jDialog.setVisible(true);
                        jDialog.setLocationRelativeTo(JMacrosMenu);
                        while (true) {
                            jLabel.setText("Mouse Position: " + MouseInfo.getPointerInfo().getLocation().x + ", " + MouseInfo.getPointerInfo().getLocation().y);

                        }
                    }
                });
                thread.start();
            }
        });

        // Add a separator
        JMacrosMenu.addSeparator();

        // Protected Run
        JMacrosMenuProtectedRun = new JCheckBoxMenuItem("Protected Run");
        JMacrosMenuProtectedRun.setMnemonic(KeyEvent.VK_P);
        JMacrosMenuProtectedRun.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_P, ActionEvent.ALT_MASK
        ));
        JMacrosMenuProtectedRun.getAccessibleContext().setAccessibleDescription(
                "Turning this off may crash the JMacros app");
        JMacrosMenuProtectedRun.setState(true);
        JMacrosMenu.add(JMacrosMenuProtectedRun);

        // Add another separator
        JMacrosMenu.addSeparator();

        // Add Instructions Submenu
        JMacrosAddComponent = new JMenu("Add Instruction");
        JMacrosAddComponent.setMnemonic(KeyEvent.VK_S);
        JMacrosMenu.add(JMacrosAddComponent);

        JMacrosComponents = new ArrayList<>();
        for (int i = 0; i < InstructionList.instructions.length; i++) {
            JMenuItem menuItem = new JMenuItem(InstructionList.instructions[i]);
            JMacrosComponents.add(menuItem);
            JMacrosAddComponent.add(menuItem);
        }

        MacroMenu = new JMenu("Macro");
        MacroMenu.setMnemonic(KeyEvent.VK_N);
        MacroMenu.getAccessibleContext().setAccessibleDescription(
                "Saving and importing macros");
        this.add(MacroMenu);

        MacroMenuImport = new JMenuItem("Import");
        MacroMenu.add(MacroMenuImport);

        MacroMenuExport = new JMenuItem("Export");
        MacroMenu.add(MacroMenuExport);
    }
}
