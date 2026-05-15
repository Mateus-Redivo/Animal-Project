package enums;

public enum Habitat {

    DOMESTIC(1, "Domestic"),
    WILD_FOREST(2, "Wild - Forest"),
    WILD_SAVANNA(3, "Wild - Savanna"),
    WILD_OCEAN(4, "Wild - Ocean"),
    URBAN(5, "Urban"),
    FARM(6, "Farm");

    private final int code;
    private final String displayName;

    Habitat(int code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }

    public int getCode() {
        return code;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Habitat fromCode(int code) {
        for (Habitat h : values()) {
            if (h.code == code)
                return h;
        }
        throw new IllegalArgumentException("Habitat invalido: " 
        + code);
    }
}