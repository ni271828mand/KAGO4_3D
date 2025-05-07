package KAGO_framework.model.ui;

public abstract class Button extends Label{

    private Runnable action;

    public Button(String text, Runnable action, int width, int height, AnchorReference anchor){
        super(text, width, height, anchor);
        this.action = action;
    }

    public void performAction(){
        action.run();
    }

    public void setAction(Runnable action){
        this.action = action;
    }
}
