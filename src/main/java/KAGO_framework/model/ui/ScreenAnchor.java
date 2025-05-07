package KAGO_framework.model.ui;

import my_project.Config;

public final class ScreenAnchor extends AnchorReference{

    public static final ScreenAnchor TOP_LEFT       = new ScreenAnchor(-Config.WINDOW_WIDTH/2, Config.WINDOW_HEIGHT/2);
    public static final ScreenAnchor TOP_CENTER     = new ScreenAnchor(0, Config.WINDOW_HEIGHT/2);
    public static final ScreenAnchor TOP_RIGHT      = new ScreenAnchor(Config.WINDOW_WIDTH/2, Config.WINDOW_HEIGHT/2);
    public static final ScreenAnchor CENTER_LEFT    = new ScreenAnchor(-Config.WINDOW_WIDTH/2, 0);
    public static final ScreenAnchor CENTER         = new ScreenAnchor(0, 0);
    public static final ScreenAnchor CENTER_RIGHT   = new ScreenAnchor(Config.WINDOW_WIDTH/2, 0);
    public static final ScreenAnchor BOTTOM_LEFT    = new ScreenAnchor(-Config.WINDOW_WIDTH/2, -Config.WINDOW_HEIGHT/2);
    public static final ScreenAnchor BOTTOM_CENTER  = new ScreenAnchor(0, -Config.WINDOW_HEIGHT/2);
    public static final ScreenAnchor BOTTOM_RIGHT   = new ScreenAnchor(Config.WINDOW_WIDTH/2, -Config.WINDOW_HEIGHT/2);

    private int x;
    private int y;

    private ScreenAnchor(int x, int y){
        super(0, 0);
        this.x = x;
        this.y = y;
    }

    public ScreenAnchor relative(int xOffset, int yOffset){
        this.xOffset = xOffset;
        this.yOffset = yOffset;
        return this;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}
