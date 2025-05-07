package KAGO_framework.model.ui;

import KAGO_framework.view.DrawTool;

public abstract class UIElement{

    protected int width, height;
    protected AnchorReference anchor;

    public UIElement(int width, int height, AnchorReference anchor){
        this.width = width;
        this.height = height;
        this.anchor = anchor;
    }

    public abstract void draw(DrawTool drawTool, Theme theme, int x, int y);

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public AnchorReference getAnchor(){
        return anchor;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setAnchor(AnchorReference anchor){
        this.anchor = anchor;
    }
}
