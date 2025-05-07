package KAGO_framework.model.ui.defaultui;

import KAGO_framework.model.ui.AnchorReference;
import KAGO_framework.model.ui.ProgressBar;
import KAGO_framework.model.ui.Theme;
import KAGO_framework.view.DrawTool;

public class DefaultProgressBar extends ProgressBar {
    public DefaultProgressBar(int width, int height, AnchorReference anchor) {
        super(width, height, anchor);
    }

    @Override
    public void draw(DrawTool drawTool, Theme theme, int x, int y) {
        drawTool.setCurrentColor(theme.primary);
        drawTool.drawFilledRectangle(x, y, width, height);
        drawTool.setCurrentColor(theme.secondary);
        drawTool.drawRectangle(x, y, width, height);

        drawTool.drawRectangle(x + 2, y + 2, ((width - 4) / 100) * progress, height - 4);
    }
}
