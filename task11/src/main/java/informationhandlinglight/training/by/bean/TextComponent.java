package informationhandlinglight.training.by.bean;

public interface TextComponent {
    void add(TextComponent component);

    void remove(TextComponent component);

    StringBuilder restore();

    TextComponent getChild(int index);
}
