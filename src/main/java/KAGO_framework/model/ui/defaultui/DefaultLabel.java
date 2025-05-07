package KAGO_framework.model.ui.defaultui;

import KAGO_framework.model.ui.AnchorReference;
import KAGO_framework.model.ui.Label;
import KAGO_framework.model.ui.Theme;
import KAGO_framework.view.DrawTool;

public class DefaultLabel extends Label{

    public DefaultLabel(String text, int width, int height, AnchorReference anchor) {
        super(text, width, height, anchor);
    }

    @Override
    public void draw(DrawTool drawTool, Theme theme, int x, int y){
        drawTool.setCurrentColor(theme.fontcolor);
        drawTool.drawText(x, y, text);
    }
}
