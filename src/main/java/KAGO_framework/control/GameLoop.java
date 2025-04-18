package KAGO_framework.control;

import KAGO_framework.model.GameObject;
import KAGO_framework.model.Scene;
import my_project.Config;

public final class GameLoop implements Runnable {

    private static boolean running = false;

    private Thread thread;

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

    int frames = 0;
    double timer = 0;

    @Override
    public void run() {
        long lastLoop = System.nanoTime();

        while(running) {
            Scene currentScene = Framework.sceneController.getCurrentScene();

            if(currentScene != null) {
                double dt = (System.nanoTime() - lastLoop) / 1_000_000_000.0;
                lastLoop = System.nanoTime();

                for (GameObject d : currentScene.getObjects()) {
                    d.update(dt);
                }

                Framework.renderManager.renderScene();

                if(Config.DEBUG) {
                    frames++;
                    timer += dt;

                    if (timer >= 1.0) {
                        System.out.println("[DEBUG] "+frames+" FPS");
                        frames = 0;
                        timer = 0;
                    }
                }
            }
        }
    }
}
