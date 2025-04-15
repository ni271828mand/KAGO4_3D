package my_project;

import KAGO_framework.control.Framework;
import KAGO_framework.model.Triangle;
import KAGO_framework.model.Scene3D;
import KAGO_framework.model.ThreeDimensionalObject;
import javafx.geometry.Point3D;

import java.awt.*;

public class Example extends ThreeDimensionalObject {

    public Example(){
        Framework.sceneController.addScene("Main", new Scene3D());
        Framework.sceneController.loadScene("Main");
        Framework.sceneController.getCurrentScene().add(this, "example");

        addTriangle(new Triangle(new Point3D(0, 0, 0), new Point3D(0, 1, 0), new Point3D(1, 1, 0)));
        addTriangle(new Triangle(new Point3D(0, 0, 0), new Point3D(1, 1, 0), new Point3D(1, 0, 0)));

        addTriangle(new Triangle(new Point3D(1, 0, 0), new Point3D(1, 1, 0), new Point3D(1, 1, 1)));
        addTriangle(new Triangle(new Point3D(1, 0, 0), new Point3D(1, 1, 1), new Point3D(1, 0, 1)));

        addTriangle(new Triangle(new Point3D(1, 0, 1), new Point3D(1, 1, 1), new Point3D(0, 1, 1)));
        addTriangle(new Triangle(new Point3D(1, 0, 1), new Point3D(0, 1, 1), new Point3D(0, 0, 1)));

        addTriangle(new Triangle(new Point3D(0, 0, 1), new Point3D(0, 1, 1), new Point3D(0, 1, 0)));
        addTriangle(new Triangle(new Point3D(0, 0, 1), new Point3D(0, 1, 0), new Point3D(0, 0, 0)));

        addTriangle(new Triangle(new Point3D(0, 1, 0), new Point3D(0, 1, 1), new Point3D(1, 1, 1)));
        addTriangle(new Triangle(new Point3D(0, 1, 0), new Point3D(1, 1, 1), new Point3D(1, 1, 0)));

        addTriangle(new Triangle(new Point3D(1, 0, 1), new Point3D(0, 0, 1), new Point3D(0, 0, 0)));
        addTriangle(new Triangle(new Point3D(1, 0, 1), new Point3D(0, 0, 0), new Point3D(1, 0, 0)));

    }

    @Override
    public void update(double dt) {

    }
}
