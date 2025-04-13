package my_project;

import KAGO_framework.control.Framework;
import KAGO_framework.model.Scene2D;
import KAGO_framework.model.SpriteObject;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Example extends SpriteObject {

    public Example() throws IOException {
        super(ImageIO.read(new File("src/main/resources/graphic/spaceship.png")));
        Framework.sceneController.addScene("Main", new Scene2D());
        Framework.sceneController.loadScene("Main");
        Framework.sceneController.getCurrentScene().add(this, "example");
    }

    @Override
    public void update(double dt) {

    }
}
