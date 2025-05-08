package KAGO_framework.control;

import KAGO_framework.model.ui.Theme;
import my_project.Config;

public final class Framework{

    public static final SceneController SCENE_CONTROLLER = new SceneController();
    public static final RenderManager RENDER_MANAGER = new RenderManager();
    private static GameLoop gameLoop;
    private static boolean running = false;
    static Theme theme = Theme.LIGHT;

    private Framework(){}

    public static void setTheme(Theme newTheme){
        theme = newTheme;
    }

    public static int getFPS(){
        return running ? gameLoop.fps : 0;
    }

    public static void start(){
        if(!running){
            if(Config.DEBUG) System.out.println("[DEBUG] Framework startet");

            running = true;

            RENDER_MANAGER.createWindow();
            gameLoop = new GameLoop();
            gameLoop.start();
        }
    }

    public static void stop(){
        if(running){
            running = false;

            gameLoop.stop();
            gameLoop = null;
            RENDER_MANAGER.deleteWindow();

            if(Config.DEBUG) System.out.println("[DEBUG] Framework gestoppt");
        }
    }
}
