package sbnz.integracija.workoutrecommender.model.enums;

public enum WeightStatus {
    DEFAULT(-4),
    TOO_YOUNG(-3),
    CHILD(-2),
    THINNESS(-1),
    MILD_THINNESS(0),
    NORMAL(1),
    OVERWEIGHT(2),
    OBESE_I(3),
    OBESE(4);

    private int value;

    WeightStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
