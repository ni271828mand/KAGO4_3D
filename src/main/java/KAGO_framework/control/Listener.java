package KAGO_framework.control;

import java.awt.event.*;

final class Listener implements KeyListener , MouseListener, MouseMotionListener, MouseWheelListener {

    Listener(){}

    @Override
    public void keyTyped(KeyEvent e) {
        for(KeyListener listener:Framework.sceneController.getCurrentScene().getKeyListener()) listener.keyTyped(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        for(KeyListener listener:Framework.sceneController.getCurrentScene().getKeyListener()) listener.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        for(KeyListener listener:Framework.sceneController.getCurrentScene().getKeyListener()) listener.keyReleased(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(GeneralMouseListener listener:Framework.sceneController.getCurrentScene().getMouseListener()) listener.mouseClicked(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        for(GeneralMouseListener listener:Framework.sceneController.getCurrentScene().getMouseListener()) listener.mousePressed(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        for(GeneralMouseListener listener:Framework.sceneController.getCurrentScene().getMouseListener()) listener.mouseReleased(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        for(GeneralMouseListener listener:Framework.sceneController.getCurrentScene().getMouseListener()) listener.mouseEntered(e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        for(GeneralMouseListener listener:Framework.sceneController.getCurrentScene().getMouseListener()) listener.mouseExited(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        for(GeneralMouseListener listener:Framework.sceneController.getCurrentScene().getMouseListener()) listener.mouseDragged(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        for(GeneralMouseListener listener:Framework.sceneController.getCurrentScene().getMouseListener()) listener.mouseMoved(e);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        for(GeneralMouseListener listener:Framework.sceneController.getCurrentScene().getMouseListener()) listener.mouseWheelMoved(e);
    }
}
