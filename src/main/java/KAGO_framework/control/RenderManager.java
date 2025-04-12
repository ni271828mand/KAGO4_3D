package KAGO_framework.control;

import KAGO_framework.view.GameWindow;
import KAGO_framework.view.Renderer;
import KAGO_framework.view.Renderer2D;

public final class RenderManager {

    private GameWindow window;
    private Renderer renderer;

    RenderManager(){
        renderer = new Renderer2D();
    }

    void renderScene(){
        renderer.renderScene(window);
    }

    void createWindow(){
        window = new GameWindow();
    }

    void deleteWindow(){
        window = null;
    }
}
