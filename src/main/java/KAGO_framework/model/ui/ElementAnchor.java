package KAGO_framework.model.ui;

public class ElementAnchor extends AnchorReference{
    private final UIElement relative;

    public ElementAnchor(UIElement relativeTo, int xOffset, int yOffset){
        super(xOffset, yOffset);
        relative = relativeTo;
    }

    public UIElement getRelative(){
        return relative;
    }
}
