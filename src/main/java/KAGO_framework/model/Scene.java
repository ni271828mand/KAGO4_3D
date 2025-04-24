package KAGO_framework.model;


import KAGO_framework.control.GeneralMouseListener;
import my_project.Config;

import java.awt.*;
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

    protected Color backgoundColor = Color.BLACK;

    public Scene(Camera camera){
        objects = new HashMap<>();
        keyListeners = new ArrayList<>();
        mouseListeners = new ArrayList<>();
        this.camera = camera;
    }

    public abstract void add(GameObject object, String name);

    public void remove(String name){
        if(objects.containsKey(name)) {
            GameObject object = objects.remove(name);

            if (object instanceof KeyListener) keyListeners.remove((KeyListener) object);
            if (object instanceof GeneralMouseListener) mouseListeners.remove((GeneralMouseListener) object);

            if(Config.DEBUG) System.out.println("[DEBUG] "+name+" gelöscht");
        }
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

    public Color getBackgoundColor(){
        return backgoundColor;
    }
}
