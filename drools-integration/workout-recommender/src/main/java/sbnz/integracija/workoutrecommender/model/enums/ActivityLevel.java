package sbnz.integracija.workoutrecommender.model.enums;

public enum ActivityLevel {
    DEFAULT(-1),
    INACTIVE(0),
    LITTLE_ACTIVE(1),
    AVERAGE_ACTIVE(2),
    VERY_ACTIVE(3);

    private int value;

    ActivityLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
