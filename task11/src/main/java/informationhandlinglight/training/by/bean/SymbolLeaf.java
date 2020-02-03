package informationhandlinglight.training.by.bean;

public class SymbolLeaf implements TextComponent {
    private char value;

    public SymbolLeaf(char value) {
        this.value = value;
    }

    @Override
    public void add(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(TextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Override
    public StringBuilder restore() {
        return new StringBuilder().append(value);
    }

    @Override
    public TextComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }
}
