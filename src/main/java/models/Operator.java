package models;

public class Operator {

    private int priority;
    private String value;
    private int originalPosition;

    public Operator(int priority, String value, int originalPosition) {
        this.priority = priority;
        this.value = value;
        this.originalPosition = originalPosition;
    }

    public int getpriority() {
        return priority;
    }

    public void setpriority(int priority) {
        this.priority = priority;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getOriginalPosition() {
        return originalPosition;
    }

    public void setOriginalPosition(int originalPosition) {
        this.originalPosition = originalPosition;
    }

    @Override
    public String toString() {
        return "Operator{" +
                "priority=" + priority +
                ", value='" + value + '\'' +
                ", originalPosition=" + originalPosition +
                '}';
    }
}
