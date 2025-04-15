package KAGO_framework.model;

import javafx.geometry.Point3D;

import java.awt.*;

public final class Triangle {

    private final Color color;
    private final Point3D[] points;

    public Triangle(Point3D p1, Point3D p2, Point3D p3){
        this.color = null;
        this.points = new Point3D[]{p1, p2, p3};
    }

    public Color getColor(){
        return color;
    }

    public Point3D[] getPoints(){
        return points;
    }

    public Point3D getPoint(int i){
        return points[i];
    }
}
