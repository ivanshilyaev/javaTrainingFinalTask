package informationhandlinglight.training.by.bean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SymbolLeaf implements TextComponent {
    private static final Logger LOGGER = LogManager.getLogger();

    private char value;

    public SymbolLeaf(char value) {
        this.value = value;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException("Adding component to a symbol");
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException("Removing component from a symbol");
    }

    @Override
    public StringBuilder restore() {
        return new StringBuilder().append(value);
    }

    @Override
    public TextComponent getChild(int index) {
        throw new UnsupportedOperationException("Getting child from a symbol");
    }
}
