package enums;

public enum TrainingLevel {
    BEGINNER(1, "Beginner"),
    INTERMEDIATE(2, "Intermediate"),
    ADVANCED(3, "Advanced"),
    PROFESSIONAL(4, "Professional");

    private final int code;
    private final String displayName;

    TrainingLevel(int code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public int getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static TrainingLevel fromCode(int code) {
        for (TrainingLevel t : values()) {
            if (t.code == code) return t;
        }
        throw new IllegalArgumentException("Invalid TrainingLevel: " + code);
    }
}
