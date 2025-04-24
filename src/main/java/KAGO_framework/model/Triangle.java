package KAGO_framework.model;

import java.awt.*;

public final class Triangle {

    private Color color;
    private final Vector3D[] points;

    public Triangle(Vector3D p1, Vector3D p2, Vector3D p3){
        this.color = null;
        this.points = new Vector3D[]{p1, p2, p3};
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color newColor){
        color = newColor;
    }

    public Vector3D[] getPoints(){
        return points;
    }

    public Vector3D getPoint(int i){
        return points[i];
    }

    public void setPoint(int i, Vector3D newPoint){
        points[i] = newPoint;
    }
}
