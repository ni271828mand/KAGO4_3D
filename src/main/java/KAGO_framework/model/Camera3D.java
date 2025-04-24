package KAGO_framework.model;

import my_project.Config;

public class Camera3D extends Camera{

    protected double z = 0;
    protected double near = 0.1;
    protected double far = 1000;
    protected double fov = 90;
    protected final double aspectRatio = (double) Config.WINDOW_HEIGHT / Config.WINDOW_WIDTH;
    protected double[][] projectionMatrix;

    public Camera3D(){
        updateProjectionMatrix();
    }

    protected void updateProjectionMatrix(){
        double fovRad = 1.0 / Math.tan(fov * 0.5 / 180 * Math.PI);

        projectionMatrix = new double[][]{
                new double[]{aspectRatio * fovRad, 0, 0, 0},
                new double[]{0, fovRad, 0, 0},
                new double[]{0, 0, far / (far - near), 1},
                new double[]{0, 0, (-far * near) / (far - near), 0}
        };
    }

    public void setFov(double degrees){
        fov = degrees;
        updateProjectionMatrix();
    }

    public void setFar(double newFar){
        far = newFar;
        updateProjectionMatrix();
    }

    public void setNear(double newNear){
        near = newNear;
        updateProjectionMatrix();
    }

    public double getZ() {
        return z;
    }

    public double[][] getProjectionMatrix(){
        return projectionMatrix;
    }
}
