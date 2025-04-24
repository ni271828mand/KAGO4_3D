package my_project;

import KAGO_framework.control.Framework;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.Scene2D;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Example extends GraphicalObject {

    public Example(){
        Framework.sceneController.addScene("Main", new Scene2D());
        Framework.sceneController.loadScene("Main");
        Framework.sceneController.getCurrentScene().add(this, "example");
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void draw(DrawTool drawTool) {

    }
}
