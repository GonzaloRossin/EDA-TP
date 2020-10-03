package utils;

public enum FormOfTransport {
    WALK(30),
    LINE(1),
    SUBWAY(2);

    private final int PENALTY;

    FormOfTransport(int penalty) {
        this.PENALTY = penalty;
    }

    public int getPENALTY() {
        return PENALTY;
    }
}
