package Main.Util;

public class Clock {
    public boolean sleep(long ms) {
        try {
            Thread.sleep(ms);
            return true;
        } catch (Exception e) {
            System.out.println("Sleep Failed! MS: " + ms);
            return false;
        }
    }
}
