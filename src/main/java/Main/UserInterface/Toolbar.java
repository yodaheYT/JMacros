package Main.UserInterface;

import javax.swing.*;

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
