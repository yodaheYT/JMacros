package Main.Controllers;

import java.io.IOException;

public class RuntimeController {
    public RuntimeController() {

    }

    public Process RunApp(String path) {
        try {
            return Runtime.getRuntime().exec(path);
        } catch (Exception e) {
            System.out.println("RuntimeController failed to start: \"" + path + "\"!");
        }
        return null;
    }
}
