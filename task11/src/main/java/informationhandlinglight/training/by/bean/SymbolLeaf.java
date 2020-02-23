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
        LOGGER.error("Adding component to a symbol");
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        LOGGER.error("Removing component from a symbol");
        throw new UnsupportedOperationException();
    }

    @Override
    public StringBuilder restore() {
        return new StringBuilder().append(value);
    }

    @Override
    public TextComponent getChild(int index) {
        LOGGER.error("Getting child from a symbol");
        throw new UnsupportedOperationException();
    }
}
