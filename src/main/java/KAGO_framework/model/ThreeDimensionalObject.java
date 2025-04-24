package KAGO_framework.model;

public abstract class ThreeDimensionalObject extends GameObject{

    private final Mesh mesh;

    public ThreeDimensionalObject(Mesh mesh){
        this.mesh = mesh;
    }

    public Mesh getMesh(){
        return mesh;
    }
}
