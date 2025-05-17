package KAGO_framework.model.ui.defaultui;

import KAGO_framework.model.ui.AnchorReference;
import KAGO_framework.model.ui.Label;
import KAGO_framework.model.ui.Theme;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class DefaultLabel extends Label{

    public DefaultLabel(String text, int width, int height, AnchorReference anchor) {
        super(text, width, height, anchor);
    }

    @Override
    public void draw(DrawTool drawTool, Theme theme){
        Graphics2D graphics = drawTool.getGraphics2D();
        int textHeight = graphics.getFontMetrics().getHeight();
        int textWidth = graphics.getFontMetrics().stringWidth(text);

        drawTool.setCurrentColor(theme.fontcolor);
        drawTool.drawText(x - (double) textWidth/2, y - (double) textHeight/2, text);
    }
}
