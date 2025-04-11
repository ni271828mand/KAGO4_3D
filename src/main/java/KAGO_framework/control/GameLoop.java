package KAGO_framework.control;

import KAGO_framework.model.GameObject;
import KAGO_framework.model.Scene;

public final class GameLoop implements Runnable {

    private static boolean running = false;

    private Thread thread;
    private long lastLoop;

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
        lastLoop = System.nanoTime();

        while(running) {
            Scene currentScene = Framework.sceneController.getCurrentScene();

            if(currentScene != null) {
                int dt = (int) ((System.nanoTime() - lastLoop) / 1000000000L);
                lastLoop = System.nanoTime();

                for (GameObject d : currentScene.getObjects()) {
                    d.update(dt);
                }

                Framework.renderManager.renderScene();
            }
        }
    }
}
