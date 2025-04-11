package KAGO_framework.model;


import KAGO_framework.control.GeneralMouseListener;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Scene {

    private final Map<String, GameObject> objects;
    private final ArrayList<KeyListener> keyListeners;
    private final ArrayList<GeneralMouseListener> mouseListeners;

    public Scene(){
        objects = new HashMap<>();
        keyListeners = new ArrayList<>();
        mouseListeners = new ArrayList<>();
    }

    public void add(String name, GameObject object){
        if(!objects.containsKey(name)){
            objects.put(name, object);

            if(object instanceof KeyListener) keyListeners.add((KeyListener) object);
            if(object instanceof MouseListener) mouseListeners.add((GeneralMouseListener) object);
        }
    }

    public void remove(String name){
        GameObject object = objects.remove(name);

        if(object instanceof KeyListener) keyListeners.remove((KeyListener) object);
        if(object instanceof GeneralMouseListener) mouseListeners.remove((GeneralMouseListener) object);
    }

    public Collection<GameObject> getObjects(){
        return objects.values();
    }

    public Collection<KeyListener> getKeyListener(){
        return keyListeners;
    }

    public Collection<GeneralMouseListener> getMouseListener(){
        return mouseListeners;
    }
}
