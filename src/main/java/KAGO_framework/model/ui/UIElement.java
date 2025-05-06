package KAGO_framework.model.ui;

import KAGO_framework.view.DrawTool;

public abstract class UIElement{

    protected double x = 0, y = 0, width = 0, height = 0;

    public abstract void draw(DrawTool drawTool, Theme theme);
}
