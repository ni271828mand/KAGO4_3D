package KAGO_framework.model.ui;

public abstract class CheckBox extends UIElement{

    protected boolean isChecked = false;

    public CheckBox(int width, int height, AnchorReference anchor) {
        super(width, height, anchor);
    }

    public boolean isChecked(){
        return isChecked;
    }

    public void setChecked(boolean isChecked){
        this.isChecked = isChecked;
    }
}
