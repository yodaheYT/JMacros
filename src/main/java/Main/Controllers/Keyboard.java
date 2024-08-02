package Main.Controllers;

import Main.Util.Clock;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Keyboard {
    //TODO: public void PressKey(key)
    //TODO: public void ReleaseKey(key)
    //TODO: public void Type(string)
    Robot robot;

    Clock clock;

    public Keyboard() {
        try {
            robot = new Robot();
            clock = new Clock();
        } catch (AWTException e) {
            System.out.println("Could not create Keyboard Robot!");
        }
    }

    public void PressKey(int key) {
        robot.keyPress(key);
    }

    public void ReleaseKey(int key) {
        robot.keyRelease(key);
    }

    public void Type(String string) {
        for (int i = 0; i < string.length(); i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                this.PressKey(KeyEvent.VK_SHIFT);
                this.PressKey(Character.toUpperCase(string.charAt(i)));
                this.ReleaseKey(KeyEvent.VK_SHIFT);
            } else {
                this.PressKey(Character.toUpperCase(string.charAt(i)));
            }
            clock.sleep(200);
        }
    }
}
