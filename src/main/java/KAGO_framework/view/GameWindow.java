package KAGO_framework.view;

import KAGO_framework.control.Framework;
import my_project.Config;

import javax.swing.*;
import java.awt.*;

public final class GameWindow extends JFrame {

    private final Canvas canvas;

    public GameWindow(){
        setTitle(Config.WINDOW_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new Canvas();

        if(Config.FULL_SCREEN){
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

            setUndecorated(true);
            gd.setFullScreenWindow(this);

            canvas.setSize(gd.getDisplayMode().getWidth(), gd.getDisplayMode().getHeight());
        }else{
            setResizable(false);

            canvas.setSize(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT);
        }

        add(canvas);
        pack();

        setLocationRelativeTo(null);
        setVisible(true);

        canvas.createBufferStrategy(2);
        canvas.setFocusable(true);
        canvas.requestFocus();

        canvas.addKeyListener(Framework.listener);
        canvas.addMouseListener(Framework.listener);
        canvas.addMouseMotionListener(Framework.listener);
        canvas.addMouseWheelListener(Framework.listener);
    }

    public Canvas getCanvas(){
        return canvas;
    }
}
