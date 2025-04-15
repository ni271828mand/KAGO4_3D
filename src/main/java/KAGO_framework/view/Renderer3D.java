package KAGO_framework.view;

import KAGO_framework.control.Framework;
import KAGO_framework.model.Camera3D;
import KAGO_framework.model.GameObject;
import KAGO_framework.model.ThreeDimensionalObject;
import KAGO_framework.model.Triangle;
import javafx.geometry.Point3D;
import my_project.Config;

import java.awt.*;

public final class Renderer3D implements Renderer{

    private static final double near = 0.1, far = 1000, fov = 90, aspectRatio = (double) Config.WINDOW_HEIGHT / Config.WINDOW_WIDTH, fovRad = 1.0 / Math.tan(fov * 0.5 / 180 * Math.PI);

    private final double[][] projectionMatrix = new double[][]{
            new double[]{aspectRatio * fovRad, 0, 0, 0},
            new double[]{0, fovRad, 0, 0},
            new double[]{0, 0, far / (far - near), 1},
            new double[]{0, 0, (-far * near) / (far - near), 0}
    };

    @Override
    public void renderScene(GameWindow window) {
        Graphics2D graphics = (Graphics2D) window.getCanvas().getBufferStrategy().getDrawGraphics();
        Camera3D camera = (Camera3D) Framework.sceneController.getCurrentScene().getCamera();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, window.getCanvas().getWidth(), window.getCanvas().getHeight());

        graphics.setColor(Color.WHITE);
        for(GameObject gameObject:Framework.sceneController.getCurrentScene().getObjects()){
            if(gameObject instanceof ThreeDimensionalObject){
                ThreeDimensionalObject object = (ThreeDimensionalObject) gameObject;

                for(Triangle triangle: object.getTriangles()){
                    graphics.drawPolygon(convertTriangle(triangle));
                }
            }
        }

        graphics.dispose();
        window.getCanvas().getBufferStrategy().show();
    }

    private Polygon convertTriangle(Triangle triangle){
        Polygon result = new Polygon();
        Triangle translated = new Triangle(new Point3D(triangle.getPoint(0).getX(), triangle.getPoint(0).getY(), triangle.getPoint(0).getZ() + 3), new Point3D(triangle.getPoint(1).getX(), triangle.getPoint(1).getY(), triangle.getPoint(1).getZ() + 3), new Point3D(triangle.getPoint(2).getX(), triangle.getPoint(2).getY(), triangle.getPoint(2).getZ() + 3));
        Triangle projected = new Triangle(multiplyMatrixPoint(translated.getPoint(0), projectionMatrix), multiplyMatrixPoint(translated.getPoint(1), projectionMatrix), multiplyMatrixPoint(translated.getPoint(2), projectionMatrix));

        for(Point3D point3D: projected.getPoints()){
            result.addPoint((int) ((point3D.getX() + 1) * Config.WINDOW_WIDTH / 2), (int) ((point3D.getY() + 1) * Config.WINDOW_HEIGHT / 2));
        }

        return result;
    }

    private Point3D multiplyMatrixPoint(Point3D point, double[][] mat){
        double x = point.getX() * mat[0][0] + point.getY() * mat[1][0] + point.getZ() * mat[2][0] + mat[3][0];
        double y = point.getX() * mat[0][1] + point.getY() * mat[1][1] + point.getZ() * mat[2][1] + mat[3][1];
        double z = point.getX() * mat[0][2] + point.getY() * mat[1][2] + point.getZ() * mat[2][2] + mat[3][2];
        double w = point.getX() * mat[0][3] + point.getY() * mat[1][3] + point.getZ() * mat[2][3] + mat[3][3];

        if(w != 0){
            x /= w;
            y /= w;
            z /= w;
        }

        return new Point3D(x, y, z);
    }
}
