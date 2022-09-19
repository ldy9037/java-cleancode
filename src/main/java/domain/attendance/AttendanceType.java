package domain.attendance;

public enum AttendanceType {
    ATTENDANCE('A'),
    LATE('L'),
    ABSENCE('P');

    private final char typeName;

    AttendanceType(char typeName) {
        this.typeName = typeName;
    }

    public char getType(){
        return typeName;
    }
}
