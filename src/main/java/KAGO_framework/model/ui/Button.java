package KAGO_framework.model.ui;

public abstract class Button extends Label{

    public Button(String text) {
        super(text);
    }

    public void onCLick(Runnable action){
        action.run();
    }
}
