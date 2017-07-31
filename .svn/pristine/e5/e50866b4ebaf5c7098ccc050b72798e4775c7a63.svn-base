package ua.nure.koval.SummaryTask3.entity;

public enum Group {
    ANTIBIOTICS("Antibiotics"),
    ERECTILE_DYSFUNCTION("Erectile dysfunction"),
    PAIN_KILLER("Pain killer"),
    VITAMINS("Vitamins");

    private final String value;

    Group(String v) {
        value = v;
    }

    public static Group fromValue(String v) {
        for (Group c : Group.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return '\'' + value() + '\'';
    }
}
