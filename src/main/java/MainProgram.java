import KAGO_framework.control.Framework;
import KAGO_framework.model.SceneUIOnly;
import KAGO_framework.model.ui.ElementAnchor;
import KAGO_framework.model.ui.ScreenAnchor;
import KAGO_framework.model.ui.defaultui.DefaultCheckBox;
import KAGO_framework.model.ui.defaultui.DefaultLabel;

public class MainProgram {
    public static void main(String[] args) {
        Framework.start();

        SceneUIOnly scene = new SceneUIOnly();
        Framework.SCENE_CONTROLLER.addScene("Main", scene);
        Framework.SCENE_CONTROLLER.loadScene("Main");

        DefaultCheckBox checkBox = new DefaultCheckBox(20, 20, ScreenAnchor.CENTER.relative(0, 0));
        scene.getUi().add(checkBox, "a");
        DefaultCheckBox checkBox2 = new DefaultCheckBox(20, 20, new ElementAnchor(checkBox, 0, 50));
        scene.getUi().add(checkBox2, "b");
        DefaultCheckBox checkBox3 = new DefaultCheckBox(20, 20, new ElementAnchor(checkBox2, 0, -15));
        scene.getUi().add(checkBox3, "c");
    }
}
