package KAGO_framework.control;

import KAGO_framework.model.Scene;

import java.awt.event.*;

public final class Listener implements KeyListener , MouseListener, MouseMotionListener, MouseWheelListener {

    public Listener(){}

    @Override
    public void keyTyped(KeyEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(KeyListener listener:currentScene.getKeyListener()) listener.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(KeyListener listener:currentScene.getKeyListener()) listener.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(KeyListener listener:currentScene.getKeyListener()) listener.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(GeneralMouseListener listener:currentScene.getMouseListener()) listener.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(GeneralMouseListener listener:currentScene.getMouseListener()) listener.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(GeneralMouseListener listener:currentScene.getMouseListener()) listener.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(GeneralMouseListener listener:currentScene.getMouseListener()) listener.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(GeneralMouseListener listener:currentScene.getMouseListener()) listener.mouseExited(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(GeneralMouseListener listener:currentScene.getMouseListener()) listener.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(GeneralMouseListener listener:currentScene.getMouseListener()) listener.mouseMoved(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        Scene currentScene = Framework.SCENE_CONTROLLER.getCurrentScene();
        if(currentScene != null) for(GeneralMouseListener listener:currentScene.getMouseListener()) listener.mouseWheelMoved(e);
    }
}
