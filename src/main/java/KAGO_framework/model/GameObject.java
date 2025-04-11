package KAGO_framework.model;

public abstract class GameObject {

    protected double x = 0, y = 0, z = 0;

    public abstract void update(double dt);

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
