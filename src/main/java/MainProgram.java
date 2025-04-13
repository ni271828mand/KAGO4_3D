import KAGO_framework.control.Framework;
import my_project.Example;

import java.io.IOException;

public class MainProgram {
    public static void main(String[] args) throws IOException {
        Framework.start();
        new Example();
    }
}
