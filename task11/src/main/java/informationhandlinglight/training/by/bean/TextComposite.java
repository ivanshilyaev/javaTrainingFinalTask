package informationhandlinglight.training.by.bean;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
    private Level level;
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public List<TextComponent> getComponents() {
        return components;
    }

    public int getComponentsSize() {
        return components.size();
    }

    @Override
    public void add(TextComponent component) {
        components.add(component);
    }

    @Override
    public void remove(TextComponent component) {
        components.remove(component);
    }

    @Override
    public StringBuilder restore() {
        StringBuilder builder = new StringBuilder();
        String delimiter;
        if (level == Level.TEXT) {
            delimiter = "\r\n";
        } else if (level == Level.PARAGRAPH || level == Level.SENTENCE) {
            delimiter = " ";
        } else {
            delimiter = "";
        }
        for (int i = 0; i < components.size(); ++i) {
            if (i != 0) {
                builder.append(delimiter);
            }
            if (level == Level.TEXT) {
                builder.append("\t");
            }
            builder.append(components.get(i).restore());
        }
        return builder;
    }

    @Override
    public TextComponent getChild(int index) {
        return components.get(index);
    }
}
