package KAGO_framework.model.ui;

import java.awt.*;

public final class Theme {

    public static final Theme LIGHT = new Theme(Color.LIGHT_GRAY, Color.DARK_GRAY, Color.BLACK, Color.WHITE);
    public static final Theme DARK = new Theme(Color.DARK_GRAY, Color.BLACK, Color.BLACK, Color.DARK_GRAY);

    public final Color primary;
    public final Color secondary;
    public final Color fontcolor;
    public final Color background;

    public Theme(Color primary, Color secondary, Color fontcolor, Color background){
        this.primary = primary;
        this.secondary = secondary;
        this.fontcolor = fontcolor;
        this.background = background;
    }
}
