package KAGO_framework.view;

import KAGO_framework.control.Framework;
import KAGO_framework.model.Camera3D;
import KAGO_framework.model.Scene3D;

import java.awt.*;

public final class Renderer3D implements Renderer{

    @Override
    public void renderScene(GameWindow window) {
        Graphics2D graphics = (Graphics2D) window.getCanvas().getBufferStrategy().getDrawGraphics();
        Scene3D scene = (Scene3D) Framework.sceneController.getCurrentScene();
        Camera3D camera = (Camera3D) scene.getCamera();

        graphics.setColor(scene.getBackgoundColor());
        graphics.fillRect(0, 0, window.getCanvas().getWidth(), window.getCanvas().getHeight());

        graphics.dispose();
        window.getCanvas().getBufferStrategy().show();
    }
}
