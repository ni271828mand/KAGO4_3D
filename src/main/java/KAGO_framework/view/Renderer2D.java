package KAGO_framework.view;

import KAGO_framework.control.Framework;
import KAGO_framework.model.Camera2D;
import KAGO_framework.model.GameObject;
import KAGO_framework.model.SpriteObject;
import KAGO_framework.model.GraphicalObject;

import java.awt.*;
import java.awt.geom.AffineTransform;
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
        Camera2D camera = (Camera2D) Framework.sceneController.getCurrentScene().getCamera();

        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, window.getCanvas().getWidth(), window.getCanvas().getHeight());

        transform.translate(-camera.getX(), -camera.getY());
        graphics.setTransform(transform);
        drawTool.setGraphics2D(graphics);

        for(Object object:Framework.sceneController.getCurrentScene().getObjects().stream().sorted(Comparator.comparingDouble(GameObject::getZ)).toArray()){
            if(((GameObject) object).getZ() >= 0){
                if (object instanceof SpriteObject) {
                    SpriteObject spriteObject = ((SpriteObject) object);
                    graphics.drawImage(spriteObject.getSprite(), (int) spriteObject.getX(), (int) spriteObject.getY(), null);
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
