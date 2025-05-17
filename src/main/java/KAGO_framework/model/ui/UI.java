package KAGO_framework.model.ui;

import KAGO_framework.control.GeneralMouseListener;
import my_project.Config;

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
        int x = e.getX() - Config.WINDOW_WIDTH/2;
        int y = e.getY() - Config.WINDOW_HEIGHT/2;

        for(UIElement element:uiElements.values()){
            int divX = Math.abs(Math.abs(element.getX()) - Math.abs(x));
            int divY = Math.abs(Math.abs(element.getY()) - Math.abs(y));

            if(divX <= element.width/2 && divY <= element.height/2){
                if (element instanceof CheckBox) {
                    ((CheckBox) element).setChecked(!((CheckBox) element).isChecked());
                } else if (element instanceof Button) {
                    ((Button) element).performAction();
                }
            }
        }
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
