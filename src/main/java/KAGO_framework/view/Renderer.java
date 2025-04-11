package KAGO_framework.view;

public interface Renderer{

    enum Mode{
        Render2D, Render3D, Custom
    }

    void renderScene(GameWindow window);
}
