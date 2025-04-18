package KAGO_framework.control;

import KAGO_framework.model.Scene;
import KAGO_framework.model.Scene2D;
import KAGO_framework.model.Scene3D;
import KAGO_framework.view.GameWindow;
import KAGO_framework.view.Renderer;
import KAGO_framework.view.Renderer2D;
import KAGO_framework.view.Renderer3D;
import my_project.Config;

import java.util.HashMap;

public final class RenderManager {

    private static final HashMap<Class<? extends Scene>, Renderer> renderers;

    static {
        renderers = new HashMap<>();
        renderers.put(Scene2D.class, new Renderer2D());
        renderers.put(Scene3D.class, new Renderer3D());
    }

    private GameWindow window;

    RenderManager(){}

    void renderScene(){
        Class<? extends Scene> sceneClass = Framework.sceneController.getCurrentScene().getClass();

        if(!renderers.containsKey(sceneClass)) throw new RuntimeException("No renderer available to render "+sceneClass);

        renderers.get(sceneClass).renderScene(window);
    }

    void createWindow(){
        window = new GameWindow();
        if(Config.DEBUG) System.out.println("[DEBUG] Fenster erstellt");
    }

    void deleteWindow(){
        window = null;
        if(Config.DEBUG) System.out.println("[DEBUG] Fenster gelöscht");
    }

    public static void addRenderer(Class<? extends Scene> sceneClass, Renderer renderer){
        if(renderers.containsKey(sceneClass)) throw new RuntimeException("Renderer for scene "+sceneClass+" is already defined");

        renderers.put(sceneClass, renderer);
        if(Config.DEBUG) System.out.println("[DEBUG] Renderer "+renderer.getClass()+" hinzugefügt");
    }
}
