package by.training.final1.assignment01.bean;

public class TrainingFile {
    private TrainingDirectory directory;
    private String name;

    public TrainingFile(TrainingDirectory directory, String name) {
        this.directory = directory;
        this.name = name;
    }

    public TrainingDirectory getDirectory() {
        return directory;
    }

    public String getName() {
        return name;
    }
}
