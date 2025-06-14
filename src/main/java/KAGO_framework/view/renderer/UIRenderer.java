package KAGO_framework.view.renderer;

import KAGO_framework.control.Framework;
import KAGO_framework.model.Scene;
import KAGO_framework.model.SceneUIOnly;
import KAGO_framework.model.ui.ElementAnchor;
import KAGO_framework.model.ui.ScreenAnchor;
import KAGO_framework.model.ui.Theme;
import KAGO_framework.model.ui.UIElement;
import KAGO_framework.view.DrawTool;
import KAGO_framework.view.GameWindow;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.HashMap;

public class UIRenderer {

    private final DrawTool drawTool;
    private HashMap<UIElement, int[]> rendered;

    public UIRenderer(){
        drawTool = new DrawTool();
    }

    public void renderUI(GameWindow window, Theme theme){
        Graphics2D graphics = (Graphics2D) window.getCanvas().getBufferStrategy().getDrawGraphics();
        AffineTransform transform = new AffineTransform();
        Scene scene = Framework.SCENE_CONTROLLER.getCurrentScene();

        transform.translate((double) window.getCanvas().getWidth()/2, (double) window.getCanvas().getHeight()/2);
        graphics.setTransform(transform);
        drawTool.setGraphics2D(graphics);

        if(scene instanceof SceneUIOnly){
            graphics.setColor(theme.background);
            graphics.fillRect(-window.getCanvas().getWidth()/2, -window.getCanvas().getHeight()/2, window.getCanvas().getWidth(), window.getCanvas().getHeight());
        }

        rendered = new HashMap<>();

        for(UIElement element:scene.getUi().getElements()){
            if(!rendered.containsKey(element) && element.getAnchor() != null){
                renderElement(element, theme);
            }
        }

        graphics.dispose();
        window.getCanvas().getBufferStrategy().show();
    }

    private void renderElement(UIElement element, Theme theme){
        if(element.getAnchor() instanceof ScreenAnchor)
            renderScreenAnchoredElement(element, theme);
        else
            renderElementAnchoredElement(element, theme);
    }

    private void renderScreenAnchoredElement(UIElement element, Theme theme){
        ScreenAnchor anchor = ((ScreenAnchor) element.getAnchor());

        int x = calcCoordinate(anchor.getX(), 0, element.getWidth()/2, anchor.getXOffset());
        int y = calcCoordinate(anchor.getY(), 0, element.getHeight()/2, anchor.getYOffset());

        element.setX(x);
        element.setY(y);
        element.draw(drawTool, theme);
        rendered.put(element, new int[]{x, y, element.getWidth()/2, element.getHeight()/2});
    }

    private void renderElementAnchoredElement(UIElement element, Theme theme){
        ElementAnchor anchor = (ElementAnchor)element.getAnchor();
        UIElement relative = anchor.getRelative();

        if(relative.getAnchor() == null)
            return;

        if(!rendered.containsKey(relative))
            renderElement(relative, theme);

        int[] ref = rendered.get(relative);

        int x = calcCoordinate(ref[0], ref[2], element.getWidth()/2, anchor.getXOffset());
        int y = calcCoordinate(ref[1], ref[3], element.getHeight()/2, anchor.getYOffset());

        element.setX(x);
        element.setY(y);
        element.draw(drawTool, theme);
        rendered.put(element, new int[]{x, y, element.getWidth()/2, element.getHeight()/2});
    }

    private int calcCoordinate(int relative, int size1, int size2, int offset){
        if(offset > 0)
            return relative + size1 + size2 + offset;

        if(offset < 0)
            return relative - (size1 + size2 + Math.abs(offset));

        return relative;
    }
}
