package KAGO_framework.model.ui;

public abstract class ProgressBar extends UIElement{

    protected int progress = 0;

    public ProgressBar(int width, int height, AnchorReference anchor) {
        super(width, height, anchor);
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = Math.min(progress, 100);
    }
}
