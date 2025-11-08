package TaskScheduler;

public class TaskEntry implements Comparable<TaskEntry> {

    private final char name;
    private int frequency;

    public TaskEntry(char name, int frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public char getName() {
        return name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    @Override
    public int compareTo(TaskEntry other) {
        return Integer.compare(other.frequency, this.frequency);
    }
}
