package KAGO_framework.control;

public final class Framework{

    public static final SceneController sceneController = new SceneController();
    public static final RenderManager renderManager = new RenderManager();
    private static GameLoop gameLoop;
    private static boolean running = false;

    private Framework(){}

    public static void start(){
        if(!running){
            running = true;

            renderManager.createWindow();
            gameLoop = new GameLoop();
            gameLoop.start();
        }
    }

    public static void stop(){
        if(running){
            running = false;

            gameLoop.stop();
            gameLoop = null;
            renderManager.deleteWindow();
        }
    }
}
