package KAGO_framework.model;

import KAGO_framework.control.GeneralMouseListener;
import my_project.Config;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class Scene2D extends Scene{

    public Scene2D() {
        super(new Camera2D());
    }

    @Override
    public void add(GameObject object, String name) {
        if(!(object instanceof GraphicalObject || object instanceof SpriteObject)) throw new RuntimeException("Illegal type");

        if(!objects.containsKey(name)){
            objects.put(name, object);

            if(object instanceof KeyListener) keyListeners.add((KeyListener) object);
            if(object instanceof MouseListener) mouseListeners.add((GeneralMouseListener) object);
        }else throw new RuntimeException(name+" already exists");

        if(Config.DEBUG) System.out.println("[DEBUG] "+name+" zu Szene hinzugefügt");
    }
}
