package KAGO_framework.model.ui;

public abstract class AnchorReference {
    protected int xOffset, yOffset;

    public AnchorReference(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    public int getXOffset(){
        return xOffset;
    }

    public int getYOffset(){
        return yOffset;
    }
}
