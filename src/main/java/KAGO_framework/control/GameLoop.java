package KAGO_framework.control;

import KAGO_framework.model.GameObject;
import KAGO_framework.model.Scene;
import my_project.Config;

public final class GameLoop implements Runnable {

    private static boolean running = false;

    private Thread thread;
    private int frames = 0;
    private double timer = 0;
    int fps = 0;

    GameLoop(){}

    synchronized void start(){
        running = true;
        this.thread = new Thread(this,"KAGO_framework.control.GameLoop");
        this.thread.start();
    }

    synchronized void stop(){
        running = false;
        try{
            this.thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastLoop = System.nanoTime();

        while(running) {
            Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();

            if(currentScene != null) {
                double dt = (System.nanoTime() - lastLoop) / 1_000_000_000.0;
                lastLoop = System.nanoTime();

                for (GameObject d : currentScene.getObjects()) {
                    d.update(dt);
                }

                Framework.RENDER_MANAGER.renderScene();

                if(Config.DEBUG) {
                    frames++;
                    timer += dt;

                    if (timer >= 5.0) {
                        fps = frames/5;
                        frames = 0;
                        timer = 0;

                        System.out.println("[DEBUG] "+fps+" FPS");
                    }
                }
            }
        }
    }
}
