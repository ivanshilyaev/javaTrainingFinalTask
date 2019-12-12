package by.training.branching.brangingseasons.bean;

public enum Season {
    WINTER("Winter"),
    SPRING("Spring"),
    SUMMER("Summer"),
    AUTUMN("Autumn");

    private String seasonText;

    Season(String season) {
        this.seasonText = season;
    }

    @Override
    public String toString() {
        return seasonText;
    }
}
