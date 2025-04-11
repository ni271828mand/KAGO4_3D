package KAGO_framework.view;

import KAGO_framework.control.Framework;
import KAGO_framework.model.GameObject;
import KAGO_framework.model.SpriteBasedObject;
import KAGO_framework.model.ThreeDimensionalObject;
import KAGO_framework.model.GraphicalObject;

import java.awt.*;
import java.util.Comparator;

public final class Renderer2D implements Renderer{

    private final DrawTool drawTool;

    public Renderer2D(){
        drawTool = new DrawTool();
    }

    @Override
    public void renderScene(GameWindow window) {
        Graphics graphics = window.getCanvas().getBufferStrategy().getDrawGraphics();
        drawTool.setGraphics2D((Graphics2D) graphics);

        for(Object object: Framework.sceneController.getCurrentScene().getObjects().stream().sorted(Comparator.comparingDouble(GameObject::getZ)).toArray()){
            if(object instanceof ThreeDimensionalObject)
                throw new RuntimeException("Unable to render 3D objects in render mode 2D");

            if(object instanceof SpriteBasedObject){
                SpriteBasedObject spriteBasedObject = ((SpriteBasedObject) object);
                graphics.drawImage(spriteBasedObject.getSprite(), (int) spriteBasedObject.getX(), (int) spriteBasedObject.getY(), null);
            }else{
                assert object instanceof GraphicalObject;

                ((GraphicalObject) object).draw(drawTool);
            }
        }
    }
}
