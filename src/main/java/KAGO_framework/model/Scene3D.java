package KAGO_framework.model;

import KAGO_framework.control.GeneralMouseListener;
import my_project.Config;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class Scene3D extends Scene{
    public Scene3D() {
        super(new Camera3D());
    }

    @Override
    public void add(GameObject object, String name) {
        if(!objects.containsKey(name)){
            objects.put(name, object);

            if(object instanceof KeyListener) keyListeners.add((KeyListener) object);
            if(object instanceof MouseListener) mouseListeners.add((GeneralMouseListener) object);

            if(Config.DEBUG) System.out.println("[DEBUG] "+name+" zu Szene hinzugefügt");
        }else throw new RuntimeException(name+" already exists");
    }
}
