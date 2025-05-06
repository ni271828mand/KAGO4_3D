package KAGO_framework.model.ui;

import KAGO_framework.control.GeneralMouseListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class UI implements GeneralMouseListener {

    private final Map<String, UIElement> uiElements;

    public UI(){
        uiElements = new HashMap<>();
    }

    public void add(UIElement element, String name){
        if(!uiElements.containsKey(name)) uiElements.put(name, element);
    }

    public void remove(String name){
        uiElements.remove(name);
    }

    public Collection<UIElement> getElements(){
        return uiElements.values();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
