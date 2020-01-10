package by.training.aggregation.assignment04.service;

public final class AmountFactory {
    private static final AmountFactory INSTANCE = new AmountFactory();
    private final USDAmount usdAmount = new USDAmount();
    private final EURAmount eurAmount = new EURAmount();
    private final BLRAmount blrAmount = new BLRAmount();

    private AmountFactory() {
    }

    public static AmountFactory getInstance() {
        return INSTANCE;
    }

    public USDAmount getUsdAmount() {
        return usdAmount;
    }

    public EURAmount getEurAmount() {
        return eurAmount;
    }

    public BLRAmount getBlrAmount() {
        return blrAmount;
    }
}
