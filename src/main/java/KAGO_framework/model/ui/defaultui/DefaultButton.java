package KAGO_framework.model.ui.defaultui;

import KAGO_framework.model.ui.AnchorReference;
import KAGO_framework.model.ui.Button;
import KAGO_framework.model.ui.Theme;
import KAGO_framework.view.DrawTool;

public class DefaultButton extends Button {

    public DefaultButton(String text, Runnable action, int width, int height, AnchorReference anchor) {
        super(text, action, width, height, anchor);
    }

    @Override
    public void draw(DrawTool drawTool, Theme theme, int x, int y) {
        drawTool.setCurrentColor(theme.primary);
        drawTool.drawFilledRectangle(x, y, width, height);
        drawTool.setCurrentColor(theme.secondary);
        drawTool.drawRectangle(x, y, width, height);

        drawTool.setCurrentColor(theme.fontcolor);
        drawTool.drawText(x, y, text);
    }
}
