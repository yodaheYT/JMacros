package Main.Util;

import Main.Instructions.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataHandler {
    public static void Save(List<Instruction> instructions, JFrame frame) {
        List<String> lines = new ArrayList<>();
        instructions.forEach(instruction -> {
            lines.add(instruction.name + ":");
            lines.add("    data=" + instruction.data);
            lines.add("    data2=" + instruction.data2);
        });
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setDialogTitle("Export .jmacro file");
        fileChooser.setFileFilter(new FileNameExtensionFilter("JMacro (*.jmacro)","jmacro"));
        fileChooser.setSelectedFile(new File("dummy.jmacro"));
        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                String path = file.getPath();
                if (!path.endsWith(".jmacro")) {
                    path += ".jmacro";
                }
                FileWriter fileWriter = new FileWriter(path);
                for (int i = 0; i < lines.size(); i++) {
                    fileWriter.write(lines.get(i) + System.lineSeparator());
                }
                fileWriter.close();
            } catch (Exception exception) {
                System.out.println("Export Failed!");
            }
        }
    }
    public static List<Instruction> Load(JFrame frame) {
        // .jmacro parser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        fileChooser.setDialogTitle("Import .jmacro file");
        fileChooser.setFileFilter(new FileNameExtensionFilter("JMacro (*.jmacro)","jmacro"));

        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                String path = file.getPath();
                if (!path.endsWith(".jmacro")) {
                    path += ".jmacro";
                }

                List<Instruction> instructions = new ArrayList<>();
                Scanner scanner = new Scanner(new File(path));
                Instruction curr = null;
                while (scanner.hasNextLine()) {
                    String string = scanner.nextLine();

                    if (string.endsWith(":")) {
                        if (!(curr == null)) {
                            instructions.add(curr);
                        }
                        switch (string.split(":")[0]) {
                            case "ClickKey":
                                curr = new ClickKey(0);
                                break;
                            case "PressKey":
                                curr = new PressKey(0);
                                break;
                            case "ReleaseKey":
                                curr = new ReleaseKey(0);
                                break;
                            case "Wait":
                                curr = new Wait(0);
                                break;
                            case "JumpToMouse":
                                curr = new JumpToMouse(0);
                                break;
                            case "MoveToMouse":
                                curr = new MoveToMouse(0);
                                break;
                            case "ClickMouse":
                                curr = new ClickMouse(0);
                                break;
                            case "PressMouse":
                                curr = new PressMouse(0);
                                break;
                            case "UnpressMouse":
                                curr = new UnpressMouse(0);
                                break;
                            case "Scroll":
                                curr = new Scroll(0);
                                break;
                        }
                    } else {
                        string = string.split("    ")[1];
                        if (string.split("=")[0].equals("data")) {
                            curr.data = Integer.parseInt(string.split("=")[1]);
                        } else if (string.split("=")[0].equals("data2")) {
                            curr.data2 = Integer.parseInt(string.split("=")[1]);
                        }
                    }
                }

                scanner.close();

                return instructions;
            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("Import Failed!");
            }
        }
        return null;
    }
}
