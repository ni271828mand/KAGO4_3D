package KAGO_framework.model;

import java.util.ArrayList;

public abstract class ThreeDimensionalObject extends GameObject{

    private final ArrayList<Triangle> triangles = new ArrayList<>();

    protected void addTriangle(Triangle triangle){
        triangles.add(triangle);
    }

    public ArrayList<Triangle> getTriangles(){
        return triangles;
    }
}
