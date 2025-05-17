package KAGO_framework.model.ui.defaultui;

import KAGO_framework.model.ui.AnchorReference;
import KAGO_framework.model.ui.Button;
import KAGO_framework.model.ui.Theme;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class DefaultButton extends Button {

    public DefaultButton(String text, Runnable action, int width, int height, AnchorReference anchor) {
        super(text, action, width, height, anchor);
    }

    @Override
    public void draw(DrawTool drawTool, Theme theme) {
        drawTool.setCurrentColor(theme.primary);
        drawTool.drawFilledRectangle(x - (double) width/2, y - (double) height/2, width, height);
        drawTool.setCurrentColor(theme.secondary);
        drawTool.drawRectangle(x - (double) width/2, y - (double) height/2, width, height);

        Graphics2D graphics = drawTool.getGraphics2D();
        int textHeight = graphics.getFontMetrics().getHeight();
        int textWidth = graphics.getFontMetrics().stringWidth(text);

        drawTool.setCurrentColor(theme.fontcolor);
        drawTool.drawText(x - (double) textWidth/2, y - (double) textHeight/2, text);
    }
}
