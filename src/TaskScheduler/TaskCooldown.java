package TaskScheduler;

public class TaskCooldown {

    private final char name;
    private final int frequency;
    private final int availability;

    public TaskCooldown(char name, int frequency, int availability) {
        this.name = name;
        this.frequency = frequency;
        this.availability = availability;
    }

    public char getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getAvailability() {
        return availability;
    }
}
