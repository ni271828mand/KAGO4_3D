package KAGO_framework.view;

import KAGO_framework.control.Framework;
import KAGO_framework.model.*;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Comparator;

public final class Renderer2D implements Renderer{

    private final DrawTool drawTool;

    public Renderer2D(){
        drawTool = new DrawTool();
    }

    @Override
    public void renderScene(GameWindow window) {
        Graphics2D graphics = (Graphics2D) window.getCanvas().getBufferStrategy().getDrawGraphics();
        AffineTransform transform = new AffineTransform();
        Scene2D scene = (Scene2D) Framework.sceneController.getCurrentScene();
        Camera2D camera = (Camera2D) scene.getCamera();

        graphics.setColor(scene.getBackgoundColor());
        graphics.fillRect(0, 0, window.getCanvas().getWidth(), window.getCanvas().getHeight());

        transform.translate(-camera.getX() + (double) window.getCanvas().getWidth()/2, -camera.getY() + (double) window.getCanvas().getHeight()/2);
        graphics.setTransform(transform);
        drawTool.setGraphics2D(graphics);

        for(Object object:Framework.sceneController.getCurrentScene().getObjects().stream().sorted(Comparator.comparingDouble(GameObject::getZ)).toArray()){
            if(((GameObject) object).getZ() >= 0){
                if (object instanceof SpriteObject) {
                    SpriteObject spriteObject = ((SpriteObject) object);
                    BufferedImage sprite = spriteObject.getSprite();
                    graphics.drawImage(sprite, (int) (spriteObject.getX() - sprite.getWidth() / 2.0), (int) (spriteObject.getY() - sprite.getHeight() / 2.0), null);
                } else {
                    assert object instanceof GraphicalObject;

                    ((GraphicalObject) object).draw(drawTool);
                }
            }
        }

        graphics.dispose();
        window.getCanvas().getBufferStrategy().show();
    }
}
