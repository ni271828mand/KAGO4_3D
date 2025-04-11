package KAGO_framework.model;

import java.awt.image.BufferedImage;

public abstract class SpriteBasedObject extends GameObject{

    private BufferedImage sprite;

    public SpriteBasedObject(BufferedImage sprite){
        this.sprite = sprite;
    }

    protected void setSprite(BufferedImage newSprite){
        if(newSprite == null)
            throw new RuntimeException("Sprite should not be null");

        sprite = newSprite;
    }

    public BufferedImage getSprite(){
        return sprite;
    }
}
