package KAGO_framework.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public interface GeneralMouseListener {

    void mouseClicked(MouseEvent e);

    void mousePressed(MouseEvent e);

    void mouseReleased(MouseEvent e);

    void mouseEntered(MouseEvent e);

    void mouseExited(MouseEvent e);

    void mouseDragged(MouseEvent e);

    void mouseMoved(MouseEvent e);

    void mouseWheelMoved(MouseWheelEvent e);
}
