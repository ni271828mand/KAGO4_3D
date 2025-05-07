package KAGO_framework.view;

import KAGO_framework.control.Listener;
import my_project.Config;

import javax.swing.*;
import java.awt.*;

public final class GameWindow extends JFrame {

    private final Canvas canvas;

    public GameWindow(){
        setTitle(Config.WINDOW_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new Canvas();

        setResizable(false);
        canvas.setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);

        add(canvas);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

        canvas.createBufferStrategy(2);
        canvas.setFocusable(true);
        canvas.requestFocus();

        Listener listener = new Listener();

        canvas.addKeyListener(listener);
        canvas.addMouseListener(listener);
        canvas.addMouseMotionListener(listener);
        canvas.addMouseWheelListener(listener);
    }

    public Canvas getCanvas(){
        return canvas;
    }
}
