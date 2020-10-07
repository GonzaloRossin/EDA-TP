package utils;

public enum FormOfTransport {
    WALK(10),
    LINE(4),
    SUBWAY(1);

    private final int PENALTY;

    FormOfTransport(int penalty) {
        this.PENALTY = penalty;
    }

    public int getPENALTY() {
        return PENALTY;
    }
}
