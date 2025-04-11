package KAGO_framework.control;

import KAGO_framework.view.GameWindow;
import KAGO_framework.view.Renderer;
import KAGO_framework.view.Renderer2D;
import KAGO_framework.view.Renderer3D;
import my_project.Config;

public final class RenderManager {

    private GameWindow window;
    private Renderer renderer;

    RenderManager(){
        setRenderMode(Config.RENDER_MODE);
    }

    public void setRenderMode(Renderer.Mode mode){
        switch(mode){
            case Render2D -> renderer = new Renderer2D();
            case Render3D -> renderer = new Renderer3D();
            case Custom -> throw new RuntimeException("Please use 'setRenderModeCustom(Renderer)' method to set render mode to custom");
        }
    }

    public void setRenderModeCustom(Renderer customRenderer){
        renderer = customRenderer;
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
