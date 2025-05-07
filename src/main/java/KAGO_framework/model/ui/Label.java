package KAGO_framework.model.ui;

public abstract class Label extends UIElement{

    protected String text;

    public Label(String text, int width, int height, AnchorReference anchor){
        super(width, height, anchor);
        this.text = text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
