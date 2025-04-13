package KAGO_framework.control;

import KAGO_framework.model.Scene;
import my_project.Config;

import java.util.HashMap;
import java.util.Map;

public final class SceneController {

    private final Map<String, Scene> scenes;
    private Scene currentScene;

    SceneController(){
        scenes = new HashMap<>();
        currentScene = null;
    }

    public void addScene(String name, Scene scene){
        if(scenes.containsKey(name))
            throw new RuntimeException("Scene "+name+" already exist");

        scenes.put(name, scene);

        if(Config.DEBUG) System.out.println("[DEBUG] Szene "+name+" hinzugefügt");
    }

    public void loadScene(String name){
        if(scenes.containsKey(name))
            currentScene = scenes.get(name);
        else throw new RuntimeException("Scene "+name+" does not exist");

        if(Config.DEBUG) System.out.println("[DEBUG] zu Szene "+name+" gewechselt");
    }

    public void removeScene(String name){
        scenes.remove(name);

        if(Config.DEBUG) System.out.println("[DEBUG] Szene "+name+" gelöscht");
    }

    public Scene getCurrentScene(){
        return currentScene;
    }
}
