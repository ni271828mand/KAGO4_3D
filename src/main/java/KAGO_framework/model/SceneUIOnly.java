package KAGO_framework.model;

public final class SceneUIOnly extends Scene{
    public SceneUIOnly() {
        super(null);
    }

    @Override
    public void add(GameObject object, String name) {
        throw new RuntimeException();
    }
}
