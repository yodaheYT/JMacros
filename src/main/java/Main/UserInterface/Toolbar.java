package Main.UserInterface;

import Main.Main;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Toolbar extends JToolBar {
    public JButton ToolbarStart;

    public JButton Clear;

    public Toolbar() {
        super();

        ToolbarStart = new JButton("Run");
        this.add(ToolbarStart);
        Clear = new JButton("Clear");
        this.add(Clear);
    }
}
