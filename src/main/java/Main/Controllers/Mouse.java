package Main.Controllers;

import Main.Util.Tuple;
import Main.Util.Clock;

import java.awt.*;
import java.util.Objects;

import static java.awt.event.InputEvent.*;

public class Mouse {
    Robot robot;

    Clock clock;

    public Mouse() {
        try {
            robot = new Robot();
            clock = new Clock();
        } catch (AWTException e) {
            System.out.println("Could not create Mouse Robot!");
        }
    }

    public void JumpTo(Tuple<Integer, Integer> pos) {
        try {
            robot.mouseMove(pos.getX(), pos.getX());
        } catch(Exception e) {
            System.out.println("JumpTo Failed! Position: (" + pos.getX() + ", " + pos.getY() + ")");
        }
    }
    public void MoveTo(Tuple<Integer, Integer> pos, int speed) {
        try {
            Tuple<Integer, Integer> cur = this.GetPos();
            int x2 = pos.x;
            int x1 = cur.x;
            int y2 = pos.y;
            int y1 = cur.y;

            double dx = (x2 - x1) / ((double) 100);
            double dy = (y2 - y1) / ((double) 100);
            double dt = speed / ((double) 100);
            for (int step = 1; step <= 100; step++) {
                Thread.sleep((int) dt);
                robot.mouseMove((int) (x1 + dx * step), (int) (y1 + dy * step));
            }
        } catch(Exception e) {
            System.out.println("MoveTo Failed! Position: (" + pos.getX() + ", " + pos.getY() + ")");
            e.printStackTrace();
        }
    }
    public void Press(int Button) {
        switch(Button) {
            case 1:
                robot.mousePress(BUTTON1_DOWN_MASK);
                break;
            case 2:
                robot.mousePress(BUTTON2_DOWN_MASK);
                break;
            case 3:
                robot.mousePress(BUTTON3_DOWN_MASK);
                break;
        }
    }
    public void Unpress(int Button) {
        switch(Button) {
            case 1:
                robot.mouseRelease(BUTTON1_DOWN_MASK);
                break;
            case 2:
                robot.mouseRelease(BUTTON2_DOWN_MASK);
                break;
            case 3:
                robot.mouseRelease(BUTTON3_DOWN_MASK);
                break;
        }
    }
    public void scroll(int notches, boolean direction) {
        if (direction) {
            robot.mouseWheel(notches);
        } else {
            robot.mouseWheel(-notches);
        }
    }
    public Tuple<Integer, Integer> GetPos() {
        return new Tuple<>(MouseInfo.getPointerInfo().getLocation().x, MouseInfo.getPointerInfo().getLocation().y);
    }
}
