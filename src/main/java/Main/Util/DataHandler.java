package Main.Util;

import Main.Instructions.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
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
                for (String line : lines) {
                    fileWriter.write(line + System.lineSeparator());
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
                        curr = switch (string.split(":")[0]) {
                            case "ClickKey" -> new ClickKey(0);
                            case "PressKey" -> new PressKey(0);
                            case "ReleaseKey" -> new ReleaseKey(0);
                            case "Wait" -> new Wait(0);
                            case "JumpToMouse" -> new JumpToMouse(0);
                            case "MoveToMouse" -> new MoveToMouse(0);
                            case "ClickMouse" -> new ClickMouse(0);
                            case "PressMouse" -> new PressMouse(0);
                            case "UnpressMouse" -> new UnpressMouse(0);
                            case "Scroll" -> new Scroll(0);
                            default -> curr;
                        };
                    } else {
                        string = string.split(" {4}")[1];
                        if (string.split("=")[0].equals("data")) {
                            assert curr != null;
                            curr.data = Integer.parseInt(string.split("=")[1]);
                        } else if (string.split("=")[0].equals("data2")) {
                            assert curr != null;
                            curr.data2 = Integer.parseInt(string.split("=")[1]);
                        }
                    }
                }

                scanner.close();

                return instructions;
            } catch (Exception exception) {
                System.out.println("Import Failed!");
            }
        }
        return null;
    }
}
