package KAGO_framework.model;


import KAGO_framework.control.GeneralMouseListener;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class Scene {

    protected final Map<String, GameObject> objects;
    protected final ArrayList<KeyListener> keyListeners;
    protected final ArrayList<GeneralMouseListener> mouseListeners;
    protected final Camera camera;

    public Scene(Camera camera){
        objects = new HashMap<>();
        keyListeners = new ArrayList<>();
        mouseListeners = new ArrayList<>();
        this.camera = camera;
    }

    public abstract void add(GameObject object, String name);

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

    public Camera getCamera(){
        return camera;
    }
}
