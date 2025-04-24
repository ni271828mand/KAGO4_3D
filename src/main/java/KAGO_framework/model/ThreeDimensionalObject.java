package KAGO_framework.model;

public abstract class ThreeDimensionalObject extends GameObject{

    private final Triangle[] triangles;

    public ThreeDimensionalObject(Triangle[] triangles){
        this.triangles = triangles;
    }

    public Triangle[] getTriangles(){
        return triangles;
    }
}
