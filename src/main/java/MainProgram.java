import KAGO_framework.control.Framework;
import KAGO_framework.model.Scene3D;
import KAGO_framework.model.SceneUIOnly;
import KAGO_framework.model.ui.Theme;
import my_project.Axis;

public class MainProgram {
    public static void main(String[] args) {
        Framework.start();

        SceneUIOnly scene = new SceneUIOnly();
        Framework.SCENE_CONTROLLER.addScene("Main", scene);
        Framework.SCENE_CONTROLLER.loadScene("Main");
    }
}
